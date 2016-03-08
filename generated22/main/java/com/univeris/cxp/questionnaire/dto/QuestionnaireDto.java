package com.univeris.cxp.questionnaire.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.Date;

import org.witchcraft.base.entity.FileAttachment;

import org.witchcraft.base.dto.BaseDto;
import java.math.BigDecimal;

public class QuestionnaireDto

extends BaseDto

{

	protected String name;

	private List<SectionDto> sectionsDto = new ArrayList<SectionDto>();

	protected Boolean isActive;

	private List<QuestionnaireMappingEntryDto> questionnaireMappingEntrysDto = new ArrayList<QuestionnaireMappingEntryDto>();

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setSections(List<SectionDto> sectionsDto) {
		this.sectionsDto = sectionsDto;
	}
	public List<SectionDto> getSections() {
		return sectionsDto;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setQuestionnaireMappingEntrys(
			List<QuestionnaireMappingEntryDto> questionnaireMappingEntrysDto) {
		this.questionnaireMappingEntrysDto = questionnaireMappingEntrysDto;
	}
	public List<QuestionnaireMappingEntryDto> getQuestionnaireMappingEntrys() {
		return questionnaireMappingEntrysDto;
	}

}
