package com.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yang.dubbo.hello.HelloService;

public class ClientMain {
	
	public static void main(String[] args) throws Exception {
	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:/webconfig/spring-*.xml"});
	        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"http://192.168.1.117/wiki/display/dubbo/consumer.xml"});
	        context.start();
	        System.out.println("启动client");
	        HelloService helloService = (HelloService) context.getBean("helloService");
	        helloService.sayHello("1234");
	        System.in.read(); // 按任意键退出
    }
	
	
}
