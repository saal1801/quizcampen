package com.quizcampen.service.dto;

import com.quizcampen.service.dao.entites.QuizcampenQuestionDAO;

public class QuizcapmenDTO {
	
	private int id;
	private String question;
	private String answer;
	private String answer1;
	private String answer11;
	private String correctAns;
	
	
	public QuizcapmenDTO() {
		
	}


	public QuizcapmenDTO(QuizcampenQuestionDAO quizcampenQuestionDAO) {
		super();
		id = quizcampenQuestionDAO.getId();
		question = quizcampenQuestionDAO.getQuestion();
		answer = quizcampenQuestionDAO.getAnswer();
		answer1 = quizcampenQuestionDAO.getAnswer1();
		answer11 = quizcampenQuestionDAO.getAnswer11();
		correctAns = quizcampenQuestionDAO.getCorrectAns();
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


	public String getAnswer1() {
		return answer1;
	}


	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}


	public String getAnswer11() {
		return answer11;
	}


	public void setAnswer11(String answer11) {
		this.answer11 = answer11;
	}


	public String getCorrectAns() {
		return correctAns;
	}


	public void setCorrectAns(String correctAns) {
		this.correctAns = correctAns;
	}


}
