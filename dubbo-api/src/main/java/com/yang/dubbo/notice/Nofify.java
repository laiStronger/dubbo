package com.yang.dubbo.notice;

public interface Nofify {
	// 调用之前
	public void onInvoke(String value);

	// 调用之后
	public void onReturn(String value);

	// 出现异常
	public void onThrow(Throwable ex, String value);
}
