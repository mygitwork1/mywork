package com.java.spring.core;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionExample {
	
	List<String> carsList;
    Map<String,Float> tempMap;
    Set<String> ownerNames;
    Properties  emailsList;
    String email;
    
    public CollectionExample(){
    	System.out.println("Collection Example....");
    }

	public List<String> getCarsList() {
		return carsList;
	}

	public void setCarsList(List<String> carsList) {
		this.carsList = carsList;
	}

	public Map<String, Float> getTempMap() {
		return tempMap;
	}

	public void setTempMap(Map<String, Float> tempMap) {
		this.tempMap = tempMap;
	}

	public Set<String> getOwnerNames() {
		return ownerNames;
	}

	public void setOwnerNames(Set<String> ownerNames) {
		this.ownerNames = ownerNames;
	}

	public Properties getEmailsList() {
		return emailsList;
	}

	public void setEmailsList(Properties emailsList) {
		this.emailsList = emailsList;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
