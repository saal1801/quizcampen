package com.quizcampen;


import java.util.ArrayList;
import java.util.List;


import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;

import com.quizcampen.entities.Quiz;
import com.quizcampen.service.dao.DAOServiceLocal;
import com.quizcampen.service.dao.entites.QuizcampenQuestionDAO;
import com.quizcampen.service.dto.QuizcapmenDTO;

public class QuizcampenService {
	
	public static final QuizcampenService INSTANCE = new QuizcampenService();
	
	private static Logger _log = Logger.getLogger(QuizcampenService.class);
	

	private DAOServiceLocal daoService;
	
	QuizcampenService(){
		initService();
	}
	
	public void initService() {
		try {
		    Context ctx = new InitialContext();
		    String current = "java:global/Quizcampen/DAOServiceEJB!com.quizcampen.service.dao.DAOServiceLocal";
		    this.daoService = ((DAOServiceLocal) ctx.lookup(current));

		} catch (Exception e) {
		    _log.error(e.getMessage());
		}
	    }

	public List<Quiz> getQuizById() {
				
		
		List<QuizcampenQuestionDAO> list = daoService.getQuiz();
		
		if (list==null) {
			_log.warn("No quiz fount now");
			return new ArrayList<Quiz>();
		}
		
		List<Quiz> quizList = new ArrayList<>();
		
		
		return quizList;
	}

//	public List<Quiz> getQuizById(int quesId) {
//		QuizcapmenDTO quizDTO = daoService.getQuuestionById(quesId);
//		
//		if (quizDTO == null) {
//			_log.warn("No Quiz found with id"+ quizDTO);
//		}
//		return new ArrayList<Quiz>();
//	}
	
//	public static List<Quiz> quizcapmen = null;
}
