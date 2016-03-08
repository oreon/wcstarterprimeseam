package com.univeris.cxp.questionnaire.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.Date;

import org.witchcraft.base.entity.FileAttachment;

import org.witchcraft.base.dto.BaseDto;
import java.math.BigDecimal;

public class SectionDto

extends BaseDto

{

	protected String name;

	protected QuestionnaireDto questionnaireDto;

	private List<QuestionDto> questionsDto = new ArrayList<QuestionDto>();

	private List<CategoryMappingEntryDto> categoryMappingEntrysDto = new ArrayList<CategoryMappingEntryDto>();

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setQuestionnaire(QuestionnaireDto questionnaireDto) {
		this.questionnaireDto = questionnaireDto;
	}

	public QuestionnaireDto getQuestionnaire() {
		return questionnaireDto;
	}

	public void setQuestions(List<QuestionDto> questionsDto) {
		this.questionsDto = questionsDto;
	}
	public List<QuestionDto> getQuestions() {
		return questionsDto;
	}

	public void setCategoryMappingEntrys(
			List<CategoryMappingEntryDto> categoryMappingEntrysDto) {
		this.categoryMappingEntrysDto = categoryMappingEntrysDto;
	}
	public List<CategoryMappingEntryDto> getCategoryMappingEntrys() {
		return categoryMappingEntrysDto;
	}

}
