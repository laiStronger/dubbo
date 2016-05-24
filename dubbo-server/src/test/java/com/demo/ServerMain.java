package com.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yang.dubbo.hello.HelloService;

public class ServerMain {
	
	public static void main(String[] args) throws Exception {
	        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"file:src/main/resources/webconfig/spring-*.xml"});
	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:/webconfig/spring-*.xml"});
	        context.start();
	        System.out.println("启动server");
	        /*HelloService helloService = (HelloService) context.getBean("helloService");
	        helloService.sayHello("1234");
	        System.out.println(context.toString());*/
	        System.in.read(); // 按任意键退出
    }
	
	
}
