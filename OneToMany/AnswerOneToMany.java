package com.tut.OneToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class AnswerOneToMany {
	
	@Id
	@Column(name = "answer_Id")
	private int answerId;
	private String answer;
	
	@ManyToOne //if question is OneToMany then Answer will be ManyToOne
	private QuestionOneToMany questionOneToMany;

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public QuestionOneToMany getQuestion() {
		return questionOneToMany;
	}

	public void setQuestion(QuestionOneToMany questionOneToMany) {
		this.questionOneToMany = questionOneToMany;
	}

	public AnswerOneToMany(int answerId, String answer, QuestionOneToMany questionOneToMany) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.questionOneToMany = questionOneToMany;
	}

	public AnswerOneToMany() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
