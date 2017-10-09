package wechat.handler;


import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import wechat.builder.TextBuilder;
import wechat.service.ReadText;
import wechat.utils.JsonUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MsgHandler extends AbstractHandler {

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {

        if (!wxMessage.getMsgType().equals(WxConsts.XML_MSG_EVENT)) {
            //TODO 可以选择将消息保存到本地
        }

        //当用户输入关键词如“你好”，“客服”等，并且有客服在线时，把消息转发给在线客服
        try {
            if (StringUtils.startsWithAny(wxMessage.getContent(), "你好", "客服")
                    && weixinService.getKefuService().kfOnlineList()
                    .getKfOnlineList().size() > 0) {
                return WxMpXmlOutMessage.TRANSFER_CUSTOMER_SERVICE()
                        .fromUser(wxMessage.getToUser())
                        .toUser(wxMessage.getFromUser()).build();
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        
        //加入三题故事代码，当用户输入“三题”时，返回自动生成的三个随机记
        try {
            if (StringUtils.startsWithAny(wxMessage.getContent(), "三词","三题")) {
            	String content = "你好，这次的三词为："+
                    "(" + ReadText.getThreeWordString() + ")" 
                    + ",努力写出精彩的故事吧！（*∩_∩*）";
                return new TextBuilder().build(content, wxMessage, weixinService);
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        

        //TODO 组装回复消息
        //String content = "收到信息内容：" + JsonUtils.toJson(wxMessage);
        String content = "收到信息内容：" + wxMessage.getContent();

        return new TextBuilder().build(content, wxMessage, weixinService);

    }

}
