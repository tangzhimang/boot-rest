package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Application implements EmbeddedServletContainerCustomizer{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SpringApplication.run(Application.class, args);

	}
	
	
	//更改Tomcat端口
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(8088);
	}

}
