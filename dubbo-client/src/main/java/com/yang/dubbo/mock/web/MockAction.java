package com.yang.dubbo.mock.web;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.yang.dubbo.mock.MockService;

@Controller("MockAction")
@Scope("prototype")
public class MockAction {

	/**
	 * 
	 */

	private String value;

	@Resource
	MockService mockService;

	public String execute() {
		value = mockService.mock("mock");
		return "sucess";
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}