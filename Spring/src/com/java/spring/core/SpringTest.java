package com.java.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
 public static void main(String[] args) {
		// TODO Auto-generated method stub
    ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfiguration.xml");
    Service service = (Service)context.getBean("service");
    service.test();
    System.out.println("args::"+service.name);
		
		
		
	}

}
