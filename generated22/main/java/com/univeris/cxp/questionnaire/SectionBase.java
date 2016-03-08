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
public abstract class SectionBase extends BaseEntity<Integer>

{

	/* */

	/* */

	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "NAME", unique = false)
	protected String name

	;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "questionnaire_id", nullable = false, updatable = true, insertable = true)
	protected Questionnaire questionnaire

	;

	@OneToMany(mappedBy = "section", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@OrderBy("id DESC")			
	protected List<Question> questions

	= new ArrayList<Question>()

	;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@OrderBy("id DESC")			
	protected List<CategoryMappingEntry> categoryMappingEntrys

	= new ArrayList<CategoryMappingEntry>()

	;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {

		return name;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public Questionnaire getQuestionnaire() {

		return questionnaire;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Question> getQuestions() {

		return questions;
	}

	public void addQuestion(Question question) {

		question.setSection((Section) this);

		if (questions == null) {
			questions = new ArrayList<com.univeris.cxp.questionnaire.Question>();
		}

		this.questions.add(question);
	}

	@Transient
	public String createListQuestionsAsString() {
		return listAsString(questions);
	}

	public void setCategoryMappingEntrys(
			List<CategoryMappingEntry> categoryMappingEntrys) {
		this.categoryMappingEntrys = categoryMappingEntrys;
	}

	public List<CategoryMappingEntry> getCategoryMappingEntrys() {

		return categoryMappingEntrys;
	}

	public void addCategoryMappingEntry(
			CategoryMappingEntry categoryMappingEntry) {

		if (categoryMappingEntrys == null) {
			categoryMappingEntrys = new ArrayList<com.univeris.cxp.questionnaire.CategoryMappingEntry>();
		}

		this.categoryMappingEntrys.add(categoryMappingEntry);
	}

	@Transient
	public String createListCategoryMappingEntrysAsString() {
		return listAsString(categoryMappingEntrys);
	}

	@Transient
	public String getDisplayName() {
		try {
			return name;
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
