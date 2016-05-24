package com.yang.dubbo.version.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yang.dubbo.version.VersionService;

@Service(version="2.0.0")
public class VersionBServiceImpl implements VersionService {

	@Override
	public String version(String value) {
		return "版本 B：" + value;
	}

}
