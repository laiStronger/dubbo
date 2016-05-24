package com.yang.dubbo.callback.impl;

import com.yang.dubbo.callback.CallbackListener;
import com.yang.dubbo.callback.CallbackService;

public class CallbackServiceImpl implements CallbackService {

	@Override
	public String callback(int value, CallbackListener listener) {
		return "回调参数返回值："+listener.changed(value);
	}

}
