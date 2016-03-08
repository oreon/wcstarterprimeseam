package com.univeris.cxp.questionnaire.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.Date;

import org.witchcraft.base.entity.FileAttachment;

import org.witchcraft.base.dto.BaseDto;
import java.math.BigDecimal;

public class QuestionDto

extends BaseDto

{

	protected String text;

	protected SectionDto sectionDto;

	private List<AnswerDto> answersDto = new ArrayList<AnswerDto>();

	protected AnswerType answerType;

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setSection(SectionDto sectionDto) {
		this.sectionDto = sectionDto;
	}

	public SectionDto getSection() {
		return sectionDto;
	}

	public void setAnswers(List<AnswerDto> answersDto) {
		this.answersDto = answersDto;
	}
	public List<AnswerDto> getAnswers() {
		return answersDto;
	}

	public void setAnswerType(AnswerType answerType) {
		this.answerType = answerType;
	}

	public AnswerType getAnswerType() {
		return answerType;
	}

}
