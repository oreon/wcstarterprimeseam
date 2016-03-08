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
public abstract class AnswerBase extends BaseEntity<Integer>

{

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id", nullable = false, updatable = true, insertable = true)
	protected Question question

	;

	/* */

	/* @Size(min=10)*/

	@Lob
	@Column(name = "TEXT", unique = false)
	protected String text

	;

	/* */

	/* */

	@Column(name = "SCORE", unique = false)
	protected Integer score

	;

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Question getQuestion() {

		return question;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {

		return text;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getScore() {

		return score;
	}

	@Transient
	public String getDisplayName() {
		try {
			return text;
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
