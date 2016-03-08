package com.univeris.cxp.questionnaire.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.Date;

import org.witchcraft.base.entity.FileAttachment;

import org.witchcraft.base.dto.BaseDto;
import java.math.BigDecimal;

public class AnswerDto

extends BaseDto

{

	protected QuestionDto questionDto;

	protected String text;

	protected Integer score;

	public void setQuestion(QuestionDto questionDto) {
		this.questionDto = questionDto;
	}

	public QuestionDto getQuestion() {
		return questionDto;
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

}
