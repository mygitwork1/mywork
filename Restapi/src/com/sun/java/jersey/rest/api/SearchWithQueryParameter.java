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
public class SearchWithQueryParameter {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response studentSearch(@QueryParam("sid")String sid) throws Exception{
		String returnString = null;
		JSONArray jsonArray = new JSONArray();
		try{
		if(sid == null){
			return Response.status(400).entity("Please enter search parameter").build();
		}
		
		DBSchema schema = new DBSchema();
		jsonArray = schema.getStudentDeatils(sid);
		returnString = jsonArray.toString();		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.status(500).entity("Server not able to process request!!!!!").build();
		}
		
		return Response.ok(returnString).build();
	}

}
