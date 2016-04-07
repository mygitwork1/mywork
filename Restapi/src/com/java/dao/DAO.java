package com.java.dao;

import javax.naming.*;
import javax.sql.*;

public class DAO {
	
	private static DataSource dataSource = null;
	private static Context context = null;
	
	public static DataSource getDBConnection() throws Exception {
		 if(dataSource != null){
			 return dataSource;
		 }
		try {
			
			if(context == null){
			   context = new InitialContext();	
			}
			
			dataSource = (DataSource)context.lookup("test");
			
		} catch (Exception e) {
             e.printStackTrace();
		}finally{
			
		}
	
	return dataSource;
	}

}
