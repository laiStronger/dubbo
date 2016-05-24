package com.yang.dubbo.stub.impl;

import com.yang.dubbo.stub.StubService;

public class StubServiceImpl implements StubService {

	@Override
	public String stub(String value) {
		System.out.println("****************");
		return "本地存根：" + value;
	}

}
