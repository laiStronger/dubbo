package com.yang.dubbo.version.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yang.dubbo.version.VersionService;

@Controller("VersionAction")
@Scope("prototype")
public class VersionAction  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 421294208978867858L;
	@Reference(version="1.0.0")
	private VersionService versionAService;
	
	@Reference(version="2.0.0")
	private VersionService versionBService;

	private String valueA;

	private String valueB;

	public String execute() {
		valueA = versionAService.version("aaaaaaaaaaaa");
		valueB = versionBService.version("bbbbbbbbbbbb");
		return "success";
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
