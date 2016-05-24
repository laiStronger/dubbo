
package com.demo.springmvc.web.test;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yang.dubbo.hello.HelloService;
//@Controller
@RestController
public class TestConstroller {

	private static final Log logger = LogFactory.getLog(TestConstroller.class);
	
	@Resource
	HelloService helloService;
	
	@ResponseBody
	@RequestMapping("dubbo")
	public String echo() {
		return helloService.sayHello("Dubbo");
		//return null;
	}
	
	
}
