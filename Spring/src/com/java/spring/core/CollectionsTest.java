package com.java.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionsTest {

	public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/java/spring/resource/SpringConfiguration.xml");
	CollectionExample example  = context.getBean("collections",CollectionExample.class);
	System.out.println("Cars List:::"+example.getCarsList());
	System.out.println("Temratures:::"+example.getTempMap());
	System.out.println("Owners::"+example.getOwnerNames());
	System.out.println("Email List::"+example.getEmailsList());
	System.out.println("Email::"+example.getEmail());
	}

}
