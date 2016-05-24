package com.yang.dubbo.api.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.yang.dubbo.api.ApiService;

@Controller("ApiAction")
@Scope("prototype")
public class ApiAction  {

	private String value;

	public String execute() {
		ApplicationConfig application = new ApplicationConfig();
		application.setName("client-web");

		// 连接注册中心配置
		RegistryConfig registry = new RegistryConfig();
		registry.setProtocol("zookeeper");
		registry.setAddress("10.0.1.216:2181");

		// 引用远程服务
		ReferenceConfig<ApiService> reference = new ReferenceConfig<ApiService>();
		reference.setRegistry(registry);
		reference.setGroup("api");
		reference.setApplication(application);
		reference.setInterface(ApiService.class);
		reference.setVersion("1.0.0");

		ApiService apiService = reference.get();
		value = apiService.apiTest("yang");
		return "success";
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}