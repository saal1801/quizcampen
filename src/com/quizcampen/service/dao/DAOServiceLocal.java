
package com.quizcampen.service.dao;

import com.quizcampen.service.dao.entites.QuizcampenQuestionDAO;

public interface DAOServiceLocal {
	
	public Object save(Object object);
	
	public abstract QuizcampenQuestionDAO getQuiestionByRow(String question);
	
//	public abstract QuizcampenAnswerDAO getAnswerByQuestion(String answer);

}