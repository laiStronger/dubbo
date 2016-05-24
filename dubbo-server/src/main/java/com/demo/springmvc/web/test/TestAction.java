
package com.demo.springmvc.web.test;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
@Controller
//@RestController

public class TestAction {

	private static final Log logger = LogFactory.getLog(TestAction.class);
	
	@RequestMapping(value = "hello")
	public String test(HttpServletRequest req) {
		req.setAttribute("date", new Date());

		return "user/main";
	}


	//remind ,it's post,NOT  get
	@RequestMapping(value={"test"},method=RequestMethod.POST)
	public void test() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

		java.io.InputStream is = null;
		try { 
			is = request.getInputStream();
			java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(is, "UTF-8"));
			// 读取HTTP请求内容
			String buffer = null;
			StringBuffer sb = new StringBuffer();
			while ((buffer = br.readLine()) != null) {
				sb.append(buffer);
			}
			String notifyMessage = sb.toString();
			System.out.println(notifyMessage);
		} catch (java.io.IOException e) {
			logger.error("error  info");
		}
	}	
	
	@RequestMapping(value="header", method=RequestMethod.GET)
	public @ResponseBody String withHeader(@RequestHeader String Accept) {

	    return "Obtained 'Accept' header '" + Accept + "'";
	}
	
	@RequestMapping(value="header2", method=RequestMethod.GET)
	public @ResponseBody String withHeader2(@RequestHeader String service) {
		System.out.printf("\n\n%s\n\n",service);
	    return "Obtained 'service' header '" + service + "'";
	}
	
	//直接返回字符串
	//http://localhost:8061/name
	@ResponseBody
	@RequestMapping("/name")
	
	public String getUserName() {
		return "hello world:"+new Date();
	}	
	
	
	//直接返回字符串
	//http://localhost:8061/echo?name=abcdefg
	@ResponseBody
	@RequestMapping("echo")
	public String echo(@RequestParam("name")String name) {
		return "hello world:"+name;
	}
	

	//直接返回字符串
	//http://localhost:8061/utf8
	@ResponseBody
	@RequestMapping(value="utf8", produces="text/html;charset=UTF-8") 
	public String utf8() {
		return "发达省份的啥而且她热情vcxzfdsafq丫头温哥华是滴哦";
	}
	
}
