package com.java.spirng.datasource;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DataSource {
	Connection connection =null;
	public Connection getDatabaseConnection(){
		
		try {
			connection = InitialContext.doLookup("test");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

}
