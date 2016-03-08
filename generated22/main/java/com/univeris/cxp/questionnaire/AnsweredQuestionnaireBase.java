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
public abstract class AnsweredQuestionnaireBase extends BaseEntity<Integer>

{

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "questionnaire_id", nullable = false, updatable = true, insertable = true)
	protected Questionnaire questionnaire

	;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false, updatable = true, insertable = true)
	protected com.univeris.cxp.commerce.Customer customer

	;

	/*@NotNull */

	/* */

	@Lob
	@Column(name = "REMARKS", unique = false)
	protected String remarks

	;

	/*@NotNull */

	/* */

	protected Integer defaultScore

	;

	@OneToMany(mappedBy = "answeredQuestionnaire", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@OrderBy("id DESC")			
	protected List<AnsweredQuestion> answeredQuestions

	= new ArrayList<AnsweredQuestion>()

	;

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public Questionnaire getQuestionnaire() {

		return questionnaire;
	}

	public void setCustomer(com.univeris.cxp.commerce.Customer customer) {
		this.customer = customer;
	}

	public com.univeris.cxp.commerce.Customer getCustomer() {

		return customer;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRemarks() {

		return remarks;
	}

	public void setDefaultScore(Integer defaultScore) {
		this.defaultScore = defaultScore;
	}

	public Integer getDefaultScore() {

		return defaultScore;
	}

	public void setAnsweredQuestions(List<AnsweredQuestion> answeredQuestions) {
		this.answeredQuestions = answeredQuestions;
	}

	public List<AnsweredQuestion> getAnsweredQuestions() {

		return answeredQuestions;
	}

	public void addAnsweredQuestion(AnsweredQuestion answeredQuestion) {

		answeredQuestion.setAnsweredQuestionnaire((AnsweredQuestionnaire) this);

		if (answeredQuestions == null) {
			answeredQuestions = new ArrayList<com.univeris.cxp.questionnaire.AnsweredQuestion>();
		}

		this.answeredQuestions.add(answeredQuestion);
	}

	@Transient
	public String createListAnsweredQuestionsAsString() {
		return listAsString(answeredQuestions);
	}

	@Transient
	public String getDisplayName() {
		try {
			return questionnaire.getName();
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
