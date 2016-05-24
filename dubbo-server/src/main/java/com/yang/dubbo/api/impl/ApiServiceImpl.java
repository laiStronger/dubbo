package com.yang.dubbo.api.impl;

import com.yang.dubbo.api.ApiService;


public class ApiServiceImpl implements ApiService {

	@Override
	public String apiTest(String value) {
		return "API测试：" + value;
	}

}
