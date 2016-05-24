
package com.yang.dubbo.api.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.yang.dubbo.api.ApiService;


@Service("ApiProviderHelper")
public class ApiProviderHelper implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		String perfix = "yang";
		// 服务实现
		ApiService apiService = new ApiServiceImpl();

		// 当前应用配置
		ApplicationConfig application = new ApplicationConfig();
		application.setName(perfix + "-server");

		// 连接注册中心配置
		RegistryConfig registry = new RegistryConfig();
		registry.setProtocol("zookeeper");
		registry.setAddress("10.0.1.216:2181");

		// 服务提供者协议配置
		ProtocolConfig protocol = new ProtocolConfig();
		protocol.setName("dubbo");
		protocol.setPort(20880);

		// 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口

		// 服务提供者暴露服务配置
		ServiceConfig<ApiService> service = new ServiceConfig<ApiService>(); // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
		service.setApplication(application);
		service.setRegistry(registry); // 多个注册中心可以用setRegistries()
		service.setProtocol(protocol); // 多个协议可以用setProtocols()
		service.setInterface(ApiService.class);
		service.setRef(apiService);
		service.setGroup("api");
		service.setVersion("1.0.0");

		// 暴露及注册服务
		service.export();
	}

}
