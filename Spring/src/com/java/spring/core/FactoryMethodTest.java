package com.java.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryMethodTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/java/spring/resource/SpringConfiguration.xml");
	
	    ExampleBean ebean = context.getBean("eBean",ExampleBean.class);
	
	}

}
