package com.yang.dubbo.mock;


public class MockServiceMock implements MockService {
	@Override
	public String mock(String name) {
		// TODO Auto-generated method stub
		return name + "的容错数据：";
	}

}
