package com.tut.OneToMany;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CollectionId;

import com.tut.OneToOne.Answer;

@Entity
public class QuestionOneToMany {
	@Id
	@Column(name = "question_id")
	private int questionId;
	
	private String question;
	
	//if you dont use mappedBy then it will create new table
	@OneToMany(mappedBy = "questionOneToMany") //before using mappedBy it was creating different table
	private List<AnswerOneToMany> answerOneToManies; //list to store many items

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	

	public List<AnswerOneToMany> getAnswerOneToManies() {
		return answerOneToManies;
	}

	public void setAnswerOneToManies(List<AnswerOneToMany> answerOneToManies) {
		this.answerOneToManies = answerOneToManies;
	}
	
	

	public QuestionOneToMany(int questionId, String question, List<AnswerOneToMany> answerOneToManies) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answerOneToManies = answerOneToManies;
	}

	public QuestionOneToMany() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
