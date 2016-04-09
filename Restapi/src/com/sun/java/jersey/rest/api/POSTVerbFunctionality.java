package com.sun.java.jersey.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import com.java.dao.DBSchema;
import com.java.dao.Studentdao;

@Path("/post/submit")
public class POSTVerbFunctionality {
	
	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED,MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	public Response addStudent(String inputData) throws Exception{
		
		String returningString = null;
		
		DBSchema dbSchema = new DBSchema();
		try {
			System.out.println("Input data:::"+inputData);
			
			/*
			 * ObjectMapper is from Jackson Processor framework
			 * http://jackson.codehaus.org/
			 * 
			 * Using the readValue method, you can parse the json from the http request
			 * and data bind it to a Java Class.
			 */
			
			ObjectMapper mapper = new ObjectMapper();
			
			Studentdao studentdao = mapper.readValue(inputData, Studentdao.class);
			Integer http_code     = dbSchema.insertStudent(studentdao.getsID(),
					                                       studentdao.getfName(),
					                                       studentdao.getlName(),
					                                       studentdao.getAddress(),
					                                       studentdao.getDoj(),
					                                       studentdao.getDob(),
					                                       studentdao.getCource(),
					                                       studentdao.getGrade());
			if(http_code == 200){
				returningString = "Student added successfully!!!!!!!!!";
			}else{
				return Response.status(500).entity("Unable to add student please try againg after some time thanks....").build();
			}
			
		} catch (Exception e) {

		e.printStackTrace();
		return Response.status(500).entity("Server unable to process you request....").build();
		}
		return Response.ok(returningString).build();
		
	}

}
