package com.java.dao;

import java.sql.Connection;

import javax.naming.*;
import javax.sql.*;

public class DAO {
	
	private static DataSource dataSource = null;
	private static Context context = null;
	
	// single instance for multiple db calls, avoiding db connection for each call
	public static DataSource getDBConnection() throws Exception {
		 if(dataSource != null){
			 return dataSource;
		 }
		 // creating db connection
		try {
			
			if(context == null){
			   context = new InitialContext();	
			}
			
			// lookup for jndi name test to connect to the data base
			dataSource = (DataSource)context.lookup("test");
			
		} catch (Exception e) {
             e.printStackTrace();
		}finally{
			
		}
	
	return dataSource;
	}
	
	
	public static Connection oracleStudentsConnection() {
		Connection conn = null;
		try {
			conn = getDBConnection().getConnection();
			return conn;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	

}
