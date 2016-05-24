package com.yang.dubbo.echo.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("EchoAction")
@Scope("prototype")
public class EchoAction{


	private String value;
	

	public String execute() {
		return "sucess";
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
