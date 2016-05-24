package com.yang.dubbo.cache.impl;

import com.yang.dubbo.cache.CacheService;


public class CacheServiceImpl implements CacheService {

	@Override
	public String cache(String value) {
		return "缓存了：" + value;
	}

}
