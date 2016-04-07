package com.sun.java.jersey.rest.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class TestClass {
	private static final String version = "0.1.12";
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVal(){
		return"<p>Welcome to REST world you will see new world !!!!</p>";
	}
	 
    @Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getVersion(){
		return"<p>Version Number:::</p>"+version;
	}
}
