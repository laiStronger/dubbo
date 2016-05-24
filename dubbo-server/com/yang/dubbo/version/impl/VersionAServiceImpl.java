package com.yang.dubbo.version.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yang.dubbo.version.VersionService;


@Service(version="1.0.0")
public class VersionAServiceImpl implements VersionService {

	@Override
	public String version(String value) {
		return "版本 A：" + value;
	}

}
