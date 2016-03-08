package com.univeris.cxp.questionnaire;

import javax.persistence.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.Filters;

import com.univeris.ewm.provider.data.basedataaccess.BaseEntity;

//import javax.validation.constraints.*;

import java.math.BigDecimal;

//import org.hibernate.search.annotations.Analyzer;
//import org.hibernate.search.annotations.Indexed;

import com.univeris.uifcommon.dataobjects.MultilingualText;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@MappedSuperclass
//@Indexed
//@Analyzer(definition = "entityAnalyzer")
public abstract class AnsweredQuestionBase extends BaseEntity<Integer>

{

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id", nullable = false, updatable = true, insertable = true)
	protected Question question

	;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "answeredQuestionnaire_id", nullable = false, updatable = true, insertable = true)
	protected AnsweredQuestionnaire answeredQuestionnaire

	;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "answer_id", nullable = true, updatable = true, insertable = true)
	protected Answer answer

	;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@OrderBy("id DESC")			
	protected List<Answer> answers

	= new ArrayList<Answer>()

	;

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Question getQuestion() {

		return question;
	}

	public void setAnsweredQuestionnaire(
			AnsweredQuestionnaire answeredQuestionnaire) {
		this.answeredQuestionnaire = answeredQuestionnaire;
	}

	public AnsweredQuestionnaire getAnsweredQuestionnaire() {

		return answeredQuestionnaire;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public Answer getAnswer() {

		return answer;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Answer> getAnswers() {

		return answers;
	}

	public void addAnswer(Answer answer) {

		if (answers == null) {
			answers = new ArrayList<com.univeris.cxp.questionnaire.Answer>();
		}

		this.answers.add(answer);
	}

	@Transient
	public String createListAnswersAsString() {
		return listAsString(answers);
	}

	@Transient
	public String getDisplayName() {
		try {
			return question + "";
		} catch (Exception e) {
			return "Exception - " + e.getMessage();
		}
	}

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private Integer _id;

	@Override
	public Integer getPK() {
		return getId(); //To change body of implemented methods use File | Settings | File Templates.
	}

	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

}
