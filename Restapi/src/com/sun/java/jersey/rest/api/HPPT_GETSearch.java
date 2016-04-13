package com.sun.java.jersey.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import com.java.dao.DBSchema;

@Path("/search")
public class HPPT_GETSearch {

	
	/**
	 * This method will return all students that are listed
	 * in student table.
	 * 
	 * Note: This is a good method for a tutorial but probably should never
	 * has a method that returns everything from a database.  There should be
	 * built in limits.
	 * http://localhost:8001/Restapi/api/search/
	 * @return - JSON array string
	 * @throws Exception
	 */
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response returnStudents()throws Exception{
		String returningString = null;
		JSONArray jsonArray= new JSONArray();
		try {
			DBSchema schema = new DBSchema();
			jsonArray = schema.getStudentDetails();
			returningString = jsonArray.toString();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.status(500).entity("Server uable to process request sorry...").build();
		}
		
		return Response.ok(returningString).build();
	}
	
}
