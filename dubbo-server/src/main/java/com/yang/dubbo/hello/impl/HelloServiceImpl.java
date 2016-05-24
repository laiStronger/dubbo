package com.yang.dubbo.hello.impl;

import com.yang.dubbo.hello.HelloService;

public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String name) {
		String result = "hello " + name;
		System.out.println(result);
		return result;
	}

}
