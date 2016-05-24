package com.yang.dubbo.notice.web;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.yang.dubbo.notice.NoticeService;

@Controller("NoticeAction")
@Scope("prototype")
public class NoticeAction {

	/**
	 * 
	 */

	private String value;

	@Resource
	NoticeService noticeService;

	public String execute() {
		try {
			value = noticeService.notice("noice");
			return "sucess";
		} catch (Exception e) {
			e.printStackTrace();
			return "sucess";
		}
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
