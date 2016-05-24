package com.yang.dubbo.stub.impl;

import com.yang.dubbo.stub.StubService;


public class StubServiceStub implements StubService {

	private final StubService stubService;

	// 构造函数传入真正的远程代理对象
	public StubServiceStub(StubService stubService) {
		this.stubService = stubService;
	}

	@Override
	public String stub(String value) {
		// 此代码在客户端执行
		// 你可以在客户端做ThreadLocal本地缓存，或预先验证参数是否合法，等等
		System.out.println("------------------");
		try {
			return stubService.stub("value");
		} catch (Exception e) {
			// 你可以容错，可以做任何AOP拦截事项
			return "容错数据";
		}
	}
}
