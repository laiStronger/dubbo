
package com.demo.springmvc.web.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.demo.springmvc.common.po.User;
//@Controller
@RestController
public class JsonTestAction {

	private static final Log logger = LogFactory.getLog(JsonTestAction.class);
	
	//直接返回字符串, notwork
	//http://localhost:8061/json
	@ResponseBody
	@RequestMapping(value="json", produces="application/json")
	public Object json() {

		List<Map> list = new ArrayList<Map> (); 
		
		Map map1 = new HashMap();
		map1.put("menu_name", "菜单分类管理");
		map1.put("menu_url", "/web/sysRightsCat!list.action");
		list.add(map1);
		
		Map map2 = new HashMap();
		map2.put("menu_name", "角色管理");
		map2.put("menu_url", "www.b{aidu.com}");
		list.add(map2);
		
		Map map3 = new HashMap();
		map3.put("menu_name", "权限管理");
		map3.put("menu_url", "/web/sys[RightsCat]!list.action");
		list.add(map3);
		return list;
	}
	
	//直接返回字符串
	//inoker: java-demo-->ParamInJson
	@ResponseBody
	@RequestMapping(value="param/json",method = RequestMethod.POST)
	public String paramWithJson(@RequestBody User user) {
		String result=String.format("user name:%s\nuser id:%d\northers:%s", user.getUserName(), user.getUserId(), user.toString());
		return result;
	}

	//直接返回字符串
	//inoker: java-demo-->ParamInJson
	@ResponseBody
	@RequestMapping(value="paramjson/returnjson",method = RequestMethod.POST)
	public Object paramWithJsonAndReturn(@RequestBody User user) {
		String result=String.format("user name:%s\nuser id:%d\northers:%s", user.getUserName(), user.getUserId(), user.toString());
		System.out.println(result);
		
		user.setUserName(user.getUserName()+":hello!");
		return user;
	}
	
	
	@ResponseBody
	@RequestMapping(value="json/map",method = RequestMethod.POST)
	public Object jsonMap(@RequestBody Map user) {
		String result=String.format("user name:%s\nuser id:%d\northers:%s", user.get("userName"), user.get("userId"), user.toString());
		System.out.println(result);
		
		user.put("userId",user.get("userName")+":hello!");
		return user;
	}
	
	//直接返回json,无需参数
	@ResponseBody
	@RequestMapping(value="json/noparam",method = RequestMethod.POST)
	public Object jsonMap() {
		String result="{\"username\":\"abc\",\"userid\":123}";
		return result;
	}


	@ResponseBody
	@RequestMapping(value="json/list",method = RequestMethod.POST)
	public Object jsonList(@RequestBody List user) {
		String result=String.format("user id:%d\nuser name:%s\northers:%s", user.get(0), user.get(1), user.toString());
		System.out.println(result);
		
		user.add(user.get(1)+":hello!");
		return user;
	}
	
	@ResponseBody
	@RequestMapping(value="jsons",method = RequestMethod.GET, headers="Accept=application/json")
	public Object jsons() {

		List<Map> list = new ArrayList<Map> (); 
		
		Map map1 = new HashMap();
		map1.put("menu_name", "菜单分类管理");
		map1.put("menu_url", "/web/sysRightsCat!list.action");
		list.add(map1);
		
		Map map2 = new HashMap();
		map2.put("menu_name", "角色管理");
		map2.put("menu_url", "www.b{aidu.com}");
		list.add(map2);
		
		Map map3 = new HashMap();
		map3.put("menu_name", "权限管理");
		map3.put("menu_url", "/web/sys[RightsCat]!list.action");
		list.add(map3);
		return list;
	}
//
//	@RequestMapping(value="json3")
//	public @ResponseBody User json3() {
//		User u=new User();
//		u.setUserId(123);
//		u.setUserName("abc");
//		return u;
//	}
}
