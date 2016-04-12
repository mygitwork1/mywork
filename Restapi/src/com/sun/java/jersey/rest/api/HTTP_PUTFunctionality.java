package com.sun.java.jersey.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.java.dao.DBSchema;



@Path("/update")
public class HTTP_PUTFunctionality {
	
	//url:http://localhost:8001/Restapi/api/update/2/D
	@Path("/{fname}/{lname}")
	@PUT
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED,MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateStudent(@PathParam("fname")String fname,@PathParam("lname")String lname,String incomingData)throws Exception{
		System.out.println("fname:::"+fname+":::grade:::"+lname);
		System.out.println("incomingData:::::"+incomingData);
		
		Integer sidpk;
		String  cource;
		String returingString = null;
		JSONArray array = new JSONArray();
		JSONObject object = new JSONObject();
		DBSchema schema = new DBSchema();
		try {
			JSONObject parseData = new JSONObject(incomingData);
			sidpk=parseData.optInt("SID");
		    cource = parseData.optString("COURCE");
			
			Integer http_code = schema.updateStudent(sidpk,cource);
			System.out.println("HTTP_CODE:::"+http_code);
			if(http_code == 200){
				object.put("HTTP_CODE",200);
				object.put("MSG","Student updated successfylly......");
				
			}else{
				return Response.status(500).entity("Not able to update student please try again after some time!!!!!!").build();
			}
			returingString = array.put(object).toString();
		} catch (Exception e) {
           e.printStackTrace();
           return Response.status(500).entity("Not able to update student please try again after some time!!!!!!").build();
		
		}
		return Response.ok(returingString).build();
	}
	
	
	//url: http://localhost:8001/Restapi/api/update?sid=1&grade=D
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateStudentUsingQueryParams(@QueryParam("sid")Integer sid,@QueryParam("grade")String grade)throws Exception{
		System.out.println("sid:::"+sid+":::grade:::"+grade);
		String returingString = null;
		try {
			DBSchema schema = new DBSchema();
			Integer http_code = schema.updateStudent(sid, grade);
			System.out.println("HTTP_CODE:::"+http_code);
			if(http_code == 200){
			returingString = "Student updated successfylly......";	
			}else{
				return Response.status(500).entity("Server Not able to process your requst!!!!!!").build();
			}
		} catch (Exception e) {
           e.printStackTrace();
           return Response.status(500).entity("Server Not able to process your requst!!!!!!").build();
		
		}
		return Response.ok(returingString).build();
	}

}
