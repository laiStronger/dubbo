package com.yang.dubbo.group.impl;

import java.util.ArrayList;
import java.util.List;

import com.yang.dubbo.group.GroupService;


public class StbServiceImpl implements GroupService {

	@Override
	public List<String> group(String value) {
		List<String> list = new ArrayList<String>();
		list.add("分组-机顶盒：" + value);
		return list;
	}

}
