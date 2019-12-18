package com.quizcampen.webservice;


import java.awt.HeadlessException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.jboss.resteasy.spi.UnhandledException;

import com.quizcampen.QuizcampenService;
import com.quizcampen.entities.Quiz;
import com.quizcampen.utils.HTMLReader;

import client.GUI;
import io.swagger.annotations.ApiOperation;




@Path("/quiz")
public class QuizcampenServiceResource {
	
	
	private final Map<String, Quiz> QuizDB = new HashMap<>();
		@GET
		@Path("/")
	    @Produces({ "text/html; charset=UTF-8"  })
	    public Response getQuiz() {

			/*GUI gUI = null;
			try {
				gUI = new GUI();
			} catch (UnhandledException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			String output = "<button>Hello World!</button>" +
					"<p>RESTful Service is running ... <br>Ping @ " + new Date().toString() + "</p<br>";
			return Response.status(200).entity(output).build();
	    
	}
		
		/*private void setAnswerQuestionSuccess(String question, Quiz successResponse) {

			QuizDB.put(question, successResponse);

		}

		public static Response.ResponseBuilder getAllowOrginResponseBuilder() {

			Response.ResponseBuilder builder = Response.ok().header("Access-Control-Allow-Origin", "*");

			return builder;
		}*/
		
		
			/*@GET
			@Path("/getQuiz")
			@Produces({ "application/json; charset=UTF-8" })
//			@RolesAllowed("ADMIN")
			public Response getEvents(@QueryParam("question") String question, @QueryParam("answer") String answer) {

			    Quiz[] quiz = QuizcampenService.INSTANCE.getQuiz(question, answer);

			    String json = JsonConverter.convertToJson(quiz);
			    StringBuilder builder = new StringBuilder();
			    builder.append(json);

			    return Response.ok(builder.toString()).build();
			}*/
			
		 
	
	@GET
	@Path("/start")
	@Produces({ "text/html; charset=UTF-8" })
	@ApiOperation(value = "", responseContainer = "HTML")
	public Response getStartPage() {

		StringBuilder builder = new StringBuilder();

		String html = HTMLReader.START_PAGE;
		builder.append(html);

		return Response.ok(builder.toString()).build();
	}
	
	

}
