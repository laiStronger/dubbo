

package com.yang.dubbo.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @FileName DubboContext.java
 * @Description: 
 *
 * @Date Apr 14, 2016 
 * @author YangShengJun
 * @version 1.0
 * 
 */
public class DubboContext {

	public static <T> T  getService(String serviceName, Class<T> clz)  {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:webconfig/spring-client-consumer.xml");

		T service=(T)ctx.getBean(serviceName);
		return service;
	}
}
