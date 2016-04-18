package com.java.spring.core;

public class ExampleBean {
	
	private ExampleBean(){
		
	}
	
	public static ExampleBean createInstances(Foo foo,Boo boo,Integer value){
		
		ExampleBean eBean = new ExampleBean();
		return eBean;
	}

}
