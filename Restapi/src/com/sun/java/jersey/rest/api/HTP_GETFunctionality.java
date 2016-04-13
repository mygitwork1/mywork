package com.sun.java.jersey.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import com.java.dao.DBSchema;


@Path("/search/students")
public class HTP_GETFunctionality {
	
	/**
	 * This method will return the specific student details the user is looking for.  
	 * It uses a QueryParam bring in the data to the method.
	 * 
	 * Example would be:
	 * http://localhost:8001/Restapi/api/search/students?grade=c
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
		if(jsonArray.length() !=0){
			returnString = jsonArray.toString();	
		}else{
			return Response.status(400).entity("Result not found..").build();
		}
				
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.status(500).entity("Server not able to process request!!!!!").build();
		}
		
		return Response.ok(returnString).build();
	}

	
	/**
	 * This method will return the specific student details the user is looking for.  
	 * It uses a Path param bring in the data to the method.
	 * 
	 * Example would be:
	 * http://localhost:8001/Restapi/api/search/students/a
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
			if(array.length() !=0){
				System.out.println("Result not found error..");
				returnString = array.toString();	
			}else{
				return Response.status(400).entity("Result not found..").build();
			}
			//returnString = array.toString();
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
	 * http://localhost:8001/Restapi/api/search/students/c/11
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
			//returnString = array.toString();
			if(array.length() !=0){
				returnString = array.toString();	
			}else{
				return Response.status(400).entity("Result not found..").build();
			}
		} catch (Exception e) {

		e.printStackTrace();
		return Response.status(500).entity("Server not able process your request please try again after some time.....").build();
		}
		
		return Response.ok(returnString).build();
		
	}
	
}
