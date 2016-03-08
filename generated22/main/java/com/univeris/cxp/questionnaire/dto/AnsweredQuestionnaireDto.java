package com.univeris.cxp.questionnaire.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.Date;

import org.witchcraft.base.entity.FileAttachment;

import org.witchcraft.base.dto.BaseDto;
import java.math.BigDecimal;

public class AnsweredQuestionnaireDto

extends BaseDto

{

	protected QuestionnaireDto questionnaireDto;

	protected com.univeris.cxp.commerce.dto.CustomerDto customerDto;

	protected String remarks;

	protected Integer defaultScore;

	private List<AnsweredQuestionDto> answeredQuestionsDto = new ArrayList<AnsweredQuestionDto>();

	public void setQuestionnaire(QuestionnaireDto questionnaireDto) {
		this.questionnaireDto = questionnaireDto;
	}

	public QuestionnaireDto getQuestionnaire() {
		return questionnaireDto;
	}

	public void setCustomer(
			com.univeris.cxp.commerce.dto.CustomerDto customerDto) {
		this.customerDto = customerDto;
	}

	public com.univeris.cxp.commerce.dto.CustomerDto getCustomer() {
		return customerDto;
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

	public void setAnsweredQuestions(
			List<AnsweredQuestionDto> answeredQuestionsDto) {
		this.answeredQuestionsDto = answeredQuestionsDto;
	}
	public List<AnsweredQuestionDto> getAnsweredQuestions() {
		return answeredQuestionsDto;
	}

}
