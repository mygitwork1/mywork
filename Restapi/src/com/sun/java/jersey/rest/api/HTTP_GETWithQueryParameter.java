package com.sun.java.jersey.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import com.java.dao.DBSchema;

@Path("/search/queryparameter")
public class HTTP_GETWithQueryParameter {
	
	
	/**
	 * This method will return the specific student details the user is looking for.  
	 * It uses a QueryParam bring in the data to the method.
	 * 
	 * Example would be:
	 * http://localhost:8001/Restapi/api/search/queryparameter?grade=c
	 * 
	 * @param grade - student grade
	 * @return - json array results list from the database
	 * @throws Exception
	 */
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response studentSearch(@QueryParam("grade")String grade) throws Exception{
		String returnString = null;
		JSONArray jsonArray = new JSONArray();
		try{
		if(grade == null){
			return Response.status(400).entity("Please enter search parameter").build();
		}
		
		DBSchema schema = new DBSchema();
		jsonArray = schema.getStudentDeatils(grade);
		returnString = jsonArray.toString();		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.status(500).entity("Server not able to process request!!!!!").build();
		}
		
		return Response.ok(returnString).build();
	}

}
