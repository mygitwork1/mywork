package com.sun.java.jersey.rest.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/test/*")
public class TestClass {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVal(){
		return"<p>Welcome to REST world you will see new world !!!!</p>";
	}

}
