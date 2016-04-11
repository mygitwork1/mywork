package com.sun.java.jersey.rest.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.java.dao.DBSchema;

@Path("/delete/service")
public class DELETEHTTPVerbFunctionality {

	
	@Path("/{sid}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteStudent(@PathParam("sid")String sid) throws Exception{
		System.out.println("SID::"+sid);
		String returningString = null;
		
		try {
			DBSchema schema = new DBSchema();
			Integer http_code = schema.deleteStudent(Integer.parseInt(sid));
			
			if(http_code == 200){
				returningString = "Student deleted from data base successfully!!!!!!!!";
			}else{
				return Response.status(500).entity("Unable to delete student please try again after some time..").build();
			}
			
		} catch (Exception  e) {
          e.printStackTrace();
          return Response.status(500).entity("Server cannot process your request please try again after some time!!!!!!!").build();
		
		
		}
		return Response.ok(returningString).build();
		
	}
	
	
}
