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
public abstract class QuestionnaireBase extends BaseEntity<Integer>

{

	/* */

	/* */
	//@Unique(entityName = "com.univeris.cxp.questionnaire.Questionnaire", fieldName = "name")

	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "NAME", unique = true)
	protected String name

	;

	@OneToMany(mappedBy = "questionnaire", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@OrderBy("id DESC")			
	protected List<Section> sections

	= new ArrayList<Section>()

	;

	/* */

	/* */

	@Column(name = "IS_ACTIVE", unique = false)
	protected Boolean isActive

	;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@OrderBy("id DESC")			
	protected List<QuestionnaireMappingEntry> questionnaireMappingEntrys

	= new ArrayList<QuestionnaireMappingEntry>()

	;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {

		return name;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public List<Section> getSections() {

		return sections;
	}

	public void addSection(Section section) {

		section.setQuestionnaire((Questionnaire) this);

		if (sections == null) {
			sections = new ArrayList<com.univeris.cxp.questionnaire.Section>();
		}

		this.sections.add(section);
	}

	@Transient
	public String createListSectionsAsString() {
		return listAsString(sections);
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsActive() {

		return isActive;
	}

	public void setQuestionnaireMappingEntrys(
			List<QuestionnaireMappingEntry> questionnaireMappingEntrys) {
		this.questionnaireMappingEntrys = questionnaireMappingEntrys;
	}

	public List<QuestionnaireMappingEntry> getQuestionnaireMappingEntrys() {

		return questionnaireMappingEntrys;
	}

	public void addQuestionnaireMappingEntry(
			QuestionnaireMappingEntry questionnaireMappingEntry) {

		if (questionnaireMappingEntrys == null) {
			questionnaireMappingEntrys = new ArrayList<com.univeris.cxp.questionnaire.QuestionnaireMappingEntry>();
		}

		this.questionnaireMappingEntrys.add(questionnaireMappingEntry);
	}

	@Transient
	public String createListQuestionnaireMappingEntrysAsString() {
		return listAsString(questionnaireMappingEntrys);
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
