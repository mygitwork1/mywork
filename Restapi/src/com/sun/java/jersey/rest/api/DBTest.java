package com.sun.java.jersey.rest.api;

import java.sql.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.java.dao.*;

@Path("/dbtest")
public class DBTest {
	
	
	//http://localhost:8001/Restapi/api/dbtest  URI
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String testingDBConnection() throws Exception{
		
		PreparedStatement statement = null;
		Connection conn = null;
		String queryString = null;
		String result = null;
		
		try {
			
			// getting data base connection
			conn =  DAO.getDBConnection().getConnection();
			
			// query string to get current data and time from data base for testing purpose
			statement = conn.prepareStatement("select to_char(sysdate,'YYYY-MM-DD HH24:MI:SS')DATETIME FROM SYS.DUAL");
			
			ResultSet set = statement.executeQuery();
			while(set.next()){
				queryString = set.getString("DATETIME");
			}
			// creating result view to display to user
			result = "<p>Date time from data base:::</p>"+"<p>date/time retrun"+queryString+"</p>";
			
			//set.next();
			
		} catch (Exception e) {

		e.printStackTrace();
		
		}finally{
			conn.close();
		}
		
		
		// returning result string
		return result;
	}

}
