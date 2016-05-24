package com.yang.dubbo.group.web;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.yang.dubbo.group.GroupService;


@Controller("GroupAction")
@Scope("prototype")
public class GroupAction  {

	/**
	 * 
	 */
	@Resource
	private GroupService voipGroupService;

	@Resource
	private GroupService stbVoipGroupService;

	private String valueA;

	private String valueB;

	public String execute() {
		valueA = voipGroupService.group("voip").toString();
		valueB = stbVoipGroupService.group("voip And stb").toString();
		return "sucess";
	}

	public String getValueA() {
		return valueA;
	}

	public void setValueA(String valueA) {
		this.valueA = valueA;
	}

	public String getValueB() {
		return valueB;
	}

	public void setValueB(String valueB) {
		this.valueB = valueB;
	}

}
