
package com.quizcampen.service.dao;

import java.util.List;

import com.quizcampen.service.dao.entites.QuizcampenQuestionDAO;
import com.quizcampen.service.dto.QuizcapmenDTO;

public interface DAOServiceLocal {
	
	public Object save(Object object);	

	public abstract List<QuizcampenQuestionDAO> getQuiz();

//	public abstract List<QuizcampenQuestionDAO> getQuestionById(int quesId);

//	public abstract QuizcapmenDTO getQuestionById(int quesId);
	
//	public abstract QuizcampenAnswerDAO getAnswerByQuestion(String answer);

}