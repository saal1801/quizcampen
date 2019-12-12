package com.quizcampen.service.dto;

import com.quizcampen.service.dao.entites.QuizcampenQuestionDAO;

public class QuizcapmenDTO {
	
	private int id;
	private String question;
	private String answer;
	
	
	public QuizcapmenDTO() {
		
	}


	public QuizcapmenDTO(QuizcampenQuestionDAO QuizcampenQuestionDAO) {
//		super();
		this.id = QuizcampenQuestionDAO.getId();
		this.question = QuizcampenQuestionDAO.getQuestion();
		this.answer = QuizcampenQuestionDAO.getAnswer();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	

}
