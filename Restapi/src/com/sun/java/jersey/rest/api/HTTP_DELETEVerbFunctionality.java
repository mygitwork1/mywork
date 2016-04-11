package com.sun.java.jersey.rest.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.java.dao.DBSchema;

@Path("/delete")
public class HTTP_DELETEVerbFunctionality {
	

	/**
	 * This method will allow you to delete data in the student table.
	 * 
	 * We really only need the primary key from the message body but I kept
	 * the same URL path as the update (PUT) to let you see that we can use the same
	 * URL path for each http method (GET, POST, PUT, DELETE, HEAD)
	 * http://localhost:8001/Restapi/api/delete/10
	 * @param sid
	 * @return
	 * @throws Exception
	 */
	@Path("/{sid}")
	@DELETE
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteStudent(@PathParam("sid")Integer sid) throws Exception{
		System.out.println("SID::"+sid);
		String returningString = null;
		
		try {
			DBSchema schema = new DBSchema();
			Integer http_code = schema.deleteStudent(sid);
			System.out.println("http_code:::"+http_code);
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
	
	
	// url http://localhost:8001/Restapi/api/delete?sid=10
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteStudentUsingQueryParams(@QueryParam("sid")Integer sid) throws Exception{
		System.out.println("SID::"+sid);
		String returningString = null;
		
		try {
			DBSchema schema = new DBSchema();
			Integer http_code = schema.deleteStudent(sid);
			
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
