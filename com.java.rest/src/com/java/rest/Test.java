package com.java.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class Test {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getType(){
		return"welcome to restapi your code working fine!!!!!!";
	}

}
