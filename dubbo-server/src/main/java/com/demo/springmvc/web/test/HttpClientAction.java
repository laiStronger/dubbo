
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
public class HttpClientAction {

	private static final Log logger = LogFactory.getLog(HttpClientAction.class);
	
	@ResponseBody
	@RequestMapping("hc/echo")
	public String echo(@RequestParam("name")String name) {
		return "hello world:"+name;
	}
	
	
}
