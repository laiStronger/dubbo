package com.yang.dubbo.hello.action;

import com.yang.dubbo.hello.HelloService;
import com.yang.dubbo.util.DubboContext;


public class HelloMain {
	

	public static void main(String[] args) throws InterruptedException {
		HelloService service= DubboContext.getService("helloService",HelloService.class);
		System.out.println(service.sayHello("youanmi"));
	}

}
