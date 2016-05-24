package com.yang.dubbo.cache.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.yang.dubbo.cache.CacheService;

@Controller("CacheAction")
@Scope("prototype")
public class CacheAction {

	@Resource private CacheService cacheService;
	
	private String value;

	public String execute() {
		value = cacheService.cache("cache");
		return "success";
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}