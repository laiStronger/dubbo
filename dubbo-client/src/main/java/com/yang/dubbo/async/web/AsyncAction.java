package com.yang.dubbo.async.web;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.dubbo.rpc.RpcContext;
import com.yang.dubbo.group.GroupService;

@Controller("AsyncAction")
@Scope("prototype")
public class AsyncAction {

	private String valueA;
	private String valueB;

	@Resource
	private GroupService voipAysncService;

	@Resource
	private GroupService stbAysncService;

	public String execute() {
		System.out.println(voipAysncService.group("voip"));
		Future<List<String>> voip = RpcContext.getContext().getFuture();
		System.out.println(stbAysncService.group("stb"));
		Future<List<String>> stb = RpcContext.getContext().getFuture();

		try {
			valueA = voip.get().toString();
			valueB = stb.get().toString();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

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
