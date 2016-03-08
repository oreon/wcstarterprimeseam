package com.univeris.cxp.questionnaire.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.Date;

import org.witchcraft.base.entity.FileAttachment;

import org.witchcraft.base.dto.BaseDto;
import java.math.BigDecimal;

public class AnsweredQuestionDto

extends BaseDto

{

	protected QuestionDto questionDto;

	protected AnsweredQuestionnaireDto answeredQuestionnaireDto;

	protected AnswerDto answerDto;

	private List<AnswerDto> answersDto = new ArrayList<AnswerDto>();

	public void setQuestion(QuestionDto questionDto) {
		this.questionDto = questionDto;
	}

	public QuestionDto getQuestion() {
		return questionDto;
	}

	public void setAnsweredQuestionnaire(
			AnsweredQuestionnaireDto answeredQuestionnaireDto) {
		this.answeredQuestionnaireDto = answeredQuestionnaireDto;
	}

	public AnsweredQuestionnaireDto getAnsweredQuestionnaire() {
		return answeredQuestionnaireDto;
	}

	public void setAnswer(AnswerDto answerDto) {
		this.answerDto = answerDto;
	}

	public AnswerDto getAnswer() {
		return answerDto;
	}

	public void setAnswers(List<AnswerDto> answersDto) {
		this.answersDto = answersDto;
	}
	public List<AnswerDto> getAnswers() {
		return answersDto;
	}

}
