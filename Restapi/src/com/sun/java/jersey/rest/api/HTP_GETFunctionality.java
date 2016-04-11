package com.sun.java.jersey.rest.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;

import com.java.dao.DAO;
import com.java.utils.ToJSON;


@Path("/search/students")
public class HTP_GETFunctionality {
	/**
	 * This method will return all students that are listed
	 * in student table.
	 * 
	 * Note: This is a good method for a tutorial but probably should never
	 * has a method that returns everything from a database.  There should be
	 * built in limits.
	 * 
	 * @return - JSON array string
	 * @throws Exception
	 */
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public String returnStudents()throws Exception{
		String returningString = null;
	    PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			DAO dao = new DAO();
			
			connection = dao.oracleStudentsConnection();
			preparedStatement = connection.prepareStatement("select * from student");
			ResultSet set = preparedStatement.executeQuery();
			
			ToJSON converter = new ToJSON();
			JSONArray jsonArray= new JSONArray();
			
			jsonArray = converter.toJSONArray(set);
			preparedStatement.close();
			returningString = jsonArray.toString();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if(connection != null){
				connection.close();
			}
		}
		return returningString;
	}
	
}
