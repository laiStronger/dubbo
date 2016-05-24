
package com.yang.dubbo.stub.web;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.yang.dubbo.stub.StubService;

@Controller("StubAction")
@Scope("prototype")
public class StubAction{

	/**
	 * 
	 */

	@Resource StubService stubService;
	
	private String value;

	public String execute() {
		value = stubService.stub("stub");
		return "success";
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}