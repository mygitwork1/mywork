package com.java.spring.core;


public class Service {
	String name;
	Foo foo;
	
	//@ConstructorProperties({"name","foo"})
	public Service(String name,Foo foo1){
		this.name=name;
		foo = foo1;
	}
	public void test(){
		System.out.println("Welcome to spring world....."+name);
		foo.test();
	}

}
