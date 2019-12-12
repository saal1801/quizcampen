package com.quizcampen.webservice;


import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.quizcampen.utils.HTMLReader;


@Path("/quiz")
public class QuizcampenServiceResource {
	
		@GET
		@Path("/")
	    @Produces({ "text/html; charset=UTF-8" })
	    public Response getQuiz() {

			String output = "<h1>Hello World!<h1>" +
					"<p>RESTful Service is running ... <br>Ping @ " + new Date().toString() + "</p<br>";
			return Response.status(200).entity(output).build();
	    
	}
	
	@GET
	@Path("/start")
	@Produces({ "text/html; charset=UTF-8" })
	
	public Response getStartPage() {

		StringBuilder builder = new StringBuilder();

		String html = HTMLReader.START_PAGE;
		builder.append(html);

		return Response.ok(builder.toString()).build();
	}
	
	

}
