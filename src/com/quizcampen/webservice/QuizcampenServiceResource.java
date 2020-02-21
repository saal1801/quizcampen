package com.quizcampen.webservice;


import java.awt.HeadlessException;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.apache.log4j.Logger;
import org.jboss.resteasy.spi.UnhandledException;

import com.quizcampen.QuizcampenService;
import com.quizcampen.entities.Quiz;
import com.quizcampen.utils.HTMLReader;

import client.GUI;
import io.swagger.annotations.ApiOperation;




@Path("/quiz")
public class QuizcampenServiceResource {
	
	 private static final Logger _log = Logger.getLogger(QuizcampenServiceResource.class);
	private final Map<String, Quiz> QuizDB = new HashMap<>();
		@GET
		@Path("/")
	    @Produces({ "text/html; charset=UTF-8"  })
	    public Response getQuiz() {

			String output = "<button>Hello World!</button>" +
					"<p>RESTful Service is running ... <br>Ping @ " + new Date().toString() + "</p<br>";
			return Response.status(200).entity(output).build();
	    
	}
		
			
		 
	
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
	

	
	@GET
	@Path("/getQuiz")
	@Produces({ "application/json; charset=UTF-8" })
	public Response getQuizs() {

		List <Quiz> quiz = QuizcampenService.INSTANCE.getQuizById();
		 _log.info(quiz);
		 
		
		
		  List <Quiz> quizs = new ArrayList<>(); _log.info("Quizs "+quizs);
		  
		  quizs.add(new
		  Quiz(1,"Vilket språk talas i Brasilien?","Portugisiska","spanska",
		  "Italienska","Portugisiska")); quizs.add(new
		  Quiz(2,"Vilket är den största planet i solsystemet?","Jorden","Jupiter",
		  "Mars","Jupiter")); quizs.add(new
		  Quiz(3,"Vem uppfann Penicillin?","Thomas Edison","Louis Pasteur"
		  ,"Alexander Fleming","Alexander Fleming")); quizs.add(new
		  Quiz(4,"Anemofobi är rädslan för vad?","vind","mörker","mörker","vind"));
		  quizs.add(new
		  Quiz(5,"Vilket Apollo-uppdrag landade de första människorna på månen?"
		  ,"Apollo 7","Apollo 13","Apollo 11","Apollo 11")); quizs.add(new
		  Quiz(6,"Question","Answer","Answer1","Answer11","Answer1"));
		 
		 
		return Response.status(200).entity(quizs).build();
	}
	

}
