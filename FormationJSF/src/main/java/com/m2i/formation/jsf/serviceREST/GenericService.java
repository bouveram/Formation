package com.m2i.formation.jsf.serviceREST;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/item")
public class GenericService {
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String doHello() {
		return "Hello";
	}
	
	@GET
	@Path("/hello/{param}")
	@Produces(MediaType.TEXT_PLAIN)
	public String doHello(@PathParam("param") String param) {
		return "Hello " + param;
	}
	
}
