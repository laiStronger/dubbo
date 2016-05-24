package com.yang.dubbo.mock.impl;

import com.yang.dubbo.mock.MockService;

public class MockServiceImpl implements MockService {

	@Override
	public String mock(String name) {
		// TODO Auto-generated method stub
		return "本地伪装：" + name;
	}

}
