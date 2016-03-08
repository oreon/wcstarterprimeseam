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
public abstract class QuestionBase extends BaseEntity<Integer>

{

	/* */

	/* */

	@Lob
	@Column(name = "TEXT", unique = false)
	protected String text

	;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "section_id", nullable = false, updatable = true, insertable = true)
	protected Section section

	;

	@OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@OrderBy("id DESC")			
	protected List<Answer> answers

	= new ArrayList<Answer>()

	;

	/* */

	/* */

	@Column(name = "ANSWER_TYPE", unique = false)
	protected AnswerType answerType

	;

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {

		return text;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Section getSection() {

		return section;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Answer> getAnswers() {

		return answers;
	}

	public void addAnswer(Answer answer) {

		answer.setQuestion((Question) this);

		if (answers == null) {
			answers = new ArrayList<com.univeris.cxp.questionnaire.Answer>();
		}

		this.answers.add(answer);
	}

	@Transient
	public String createListAnswersAsString() {
		return listAsString(answers);
	}

	public void setAnswerType(AnswerType answerType) {
		this.answerType = answerType;
	}

	public AnswerType getAnswerType() {

		return answerType;
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
