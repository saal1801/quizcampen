package com.quizcampen.service.dao.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUIZCAPEN_QUES_ANS")
public class QuizcampenQuestionDAO {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String question;
	private String answer;
	
	public int getId() {
		
		return id;
	}

	public QuizcampenQuestionDAO() {
		
	}

	public QuizcampenQuestionDAO( String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
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

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "QuizcampenQuestionDAO [id=" + id + ", question=" + question + ", answer=" + answer + "]";
	} 
	
	
	
}
