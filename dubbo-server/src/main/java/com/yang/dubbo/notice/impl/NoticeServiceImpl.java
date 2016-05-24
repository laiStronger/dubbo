package com.yang.dubbo.notice.impl;

import com.yang.dubbo.notice.NoticeService;

public class NoticeServiceImpl implements NoticeService {

	@Override
	public String notice(String value) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		int i = 1 / 0;
		return "事件通知：" + value;
	}

}
