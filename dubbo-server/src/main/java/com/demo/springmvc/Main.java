package com.demo.springmvc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yang.dubbo.hello.HelloService;

public class Main {
	
	public static void main(String[] args) throws Exception {
	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"file:src/main/resources/spring-*.xml"});
	        context.start();
	        HelloService helloService = (HelloService) context.getBean("helloService");
	        helloService.sayHello("1234");
	        System.out.println(context.toString());
	        System.in.read(); // 按任意键退出
    }
	
	
}
