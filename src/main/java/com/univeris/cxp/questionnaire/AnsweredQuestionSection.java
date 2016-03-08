package com.univeris.cxp.questionnaire;

import java.util.List;

public class AnsweredQuestionSection {
	
	private Section section;
	
	private int score;
	
	private List<AnsweredQuestion> answeredQuestions;

	public List<AnsweredQuestion> getAnsweredQuestions() {
		return answeredQuestions;
	}

	public void setAnsweredQuestions(List<AnsweredQuestion> answeredQuestions) {
		this.answeredQuestions = answeredQuestions;
	}

	public Section getSection() {
		return section;
	}

	public AnsweredQuestionSection(Section section,
			List<AnsweredQuestion> answeredQuestions) {
		super();
		this.section = section;
		this.answeredQuestions = answeredQuestions;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
