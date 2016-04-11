package com.sun.java.jersey.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import com.java.dao.DBSchema;

@Path("/search/pathparam")
public class HTTP_GETWithPathParams {
	
	/**
	 * This method will return the specific student details the user is looking for.  
	 * It uses a Path param bring in the data to the method.
	 * 
	 * Example would be:
	 * http://localhost:8001/Restapi/api/search/pathparam/c
	 * 
	 * @param grade - student grade
	 * @return - json array results list from the database
	 * @throws Exception
	 */
	
	@Path("/{grade}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudentDetails(@PathParam("grade")String grade)throws Exception{
		
		String returnString = null;
		JSONArray array = new JSONArray();
		try {
			DBSchema dbSchema = new DBSchema();
			array = dbSchema.getStudentDeatils(grade);
			returnString = array.toString();
		} catch (Exception e) {

		e.printStackTrace();
		return Response.status(500).entity("Server not able process your request please try again after some time.....").build();
		}
		
		return Response.ok(returnString).build();
		
	}
	
	/**
	 * This method will return the specific student details the user is looking for.  
	 * It uses a Path param bring in the data to the method.
	 * 
	 * Example would be:
	 * http://localhost:8001/Restapi/api/search/pathparam/c/11
	 * 
	 * @param grade - student grade
	 * @return - json array results list from the database
	 * @throws Exception
	 */
	
	@Path("/{grade}/{sid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudentDetails(@PathParam("grade")String grade,@PathParam("sid")String sid)throws Exception{
		System.out.println("gate :::"+grade+":::"+"sid:::"+sid);
		String returnString = null;
		JSONArray array = new JSONArray();
		try {
			DBSchema dbSchema = new DBSchema();
			array = dbSchema.getStudentDeatilsWith2Params(grade,sid);
			returnString = array.toString();
		} catch (Exception e) {

		e.printStackTrace();
		return Response.status(500).entity("Server not able process your request please try again after some time.....").build();
		}
		
		return Response.ok(returnString).build();
		
	}

}
