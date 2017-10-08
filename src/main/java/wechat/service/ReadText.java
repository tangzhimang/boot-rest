package wechat.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import com.github.nobodxbodon.zhconverter.*;
import com.github.nobodxbodon.zhconverter.简繁转换类.目标;

public class ReadText {
	
	private static String FILE_NAME = "word-v2.txt";
	private static String FILE_NAME_V3 = "word-v3.txt";
	
	private static  String randString;
	
	
	
	 public static String readTxtFile(String filePath) throws Exception{
		 	
	        try {
	                String encoding="UTF8";
	                File file=new File(filePath);
	                if(file.isFile() && file.exists()){ //判断文件是否存在
	                    InputStreamReader read = new InputStreamReader(
	                    new FileInputStream(file),encoding);//考虑到编码格式
	                    BufferedReader bufferedReader = new BufferedReader(read);
	                    bufferedReader.mark((int)file.length()); 
	                    //获取文件行数i
	                    int i = 0;
	                    while(bufferedReader.readLine()!=null) {
	                    	i++;
	                    }
	                    System.out.println("the file line:" + i);
	                    
	                    //生成随机行数
	                    String lineTxt = null;
	                    int ran = (int)(Math.random()*i);
	                    System.out.println("the ran number:"+ran);
	                    
	                    //从随机数中生成随机字符串
	                    bufferedReader.reset();
	                    i=0;
	                    while((lineTxt = bufferedReader.readLine()) != null){
	                     
	                    	if(i==ran) {
	                    		System.out.println(lineTxt);
	                    		String[] arr = lineTxt.split("\\s+");
	                    		//获取随机字符串randString 
	                    		int sran = (int)(Math.random()*arr.length);
	                    		System.out.println("the arr length:"+arr.length);
	                    		randString = arr[sran] ;
	                    		System.out.println("this randString is :" + randString);
	                    		
	                    		break;
	                    	}
	                    	  i++;
	                    }
	                    
	                    
	                    read.close();
	                }else{
	                	System.out.println("找不到指定的文件");
	                }
	        } catch (Exception e) {
	            System.out.println("读取文件内容出错");
	            e.printStackTrace();
	        }
	        
	    	if(randString !=null) {
    			return randString;
    		} else {
    			System.out.println("读取字符串出错");
    			throw new Exception() ;
    		}
	     
	    }
	 
	 private String getFile(String fileName) {
	        ClassLoader classLoader = getClass().getClassLoader();
	        /**
	        getResource()方法会去classpath下找这个文件，获取到url resource, 得到这个资源后，调用url.getFile获取到 文件 的绝对路径
	        */
	        URL url = classLoader.getResource(fileName);
	        /**
	         * url.getFile() 得到这个文件的绝对路径
	         */
	       return url.getFile();
//	        File file = new File(url.getFile());
//	        System.out.println(file.exists());
	    }
	 
	 public static void main(String argv[]) throws Exception{
		 
		 getThreeWordString();
		 
	    }
	 
	 public static String getThreeWordString() throws Exception {
		 
		  ReadText rText = new ReadText();	
	      String filePath = rText.getFile(FILE_NAME);
	      String oneString = readTxtFile(filePath);
	      String filePath2 = rText.getFile(FILE_NAME_V3);
	      String twoString = readTxtFile(filePath2);
	      String threeString = readTxtFile(filePath2);
	      String str = oneString + "  " + twoString + "  " + threeString;
	     
	      String zhongString = com.github.nobodxbodon.zhconverter.简繁转换类.转换(str,目标.简体);
	      System.out.println("转换后的字符串为：" + zhongString);
	      return zhongString ;
	 }
	

}
