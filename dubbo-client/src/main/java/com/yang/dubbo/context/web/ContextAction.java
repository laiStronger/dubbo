package com.yang.dubbo.context.web;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.dubbo.rpc.RpcContext;
import com.yang.dubbo.hello.HelloService;

@Controller("ContextAction")
@Scope("prototype")
public class ContextAction{


	private String value;

	@Resource
	private HelloService helloService;

	public String execute() {
		helloService.sayHello("dubbo"); // 远程调用
		boolean isConsumerSide = RpcContext.getContext().isConsumerSide();
		String serverIP = RpcContext.getContext().getRemoteHost();
		String methodName = RpcContext.getContext().getMethodName();
		int remotePort = RpcContext.getContext().getRemotePort();
		value = "是否是消费端：" + isConsumerSide + "<br /> 服务器IP:" + serverIP + "<br /> 方法名：" + methodName + "<br /> 远程端口号：" + remotePort;
		return "success";
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}