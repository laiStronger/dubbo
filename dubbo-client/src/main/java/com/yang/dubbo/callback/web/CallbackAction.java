package com.yang.dubbo.callback.web;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.yang.dubbo.callback.CallbackListener;
import com.yang.dubbo.callback.CallbackService;

@Controller("CallbackAction")
@Scope("prototype")
public class CallbackAction {

	private String value;

	@Resource
	CallbackService callbackService;

	public String execute() {
		value = callbackService.callback(200, new CallbackListener() {

			@Override
			public int changed(int value) {
				System.out.println("------回掉-------");
				return value - 100;
			}
		});
		return "success";
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
