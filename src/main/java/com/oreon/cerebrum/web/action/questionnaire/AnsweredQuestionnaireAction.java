package com.oreon.cerebrum.web.action.questionnaire;

import java.util.ArrayList;
import java.util.List;

import org.jboss.seam.annotations.Name;

import com.univeris.cxp.questionnaire.Answer;
import com.univeris.cxp.questionnaire.AnsweredQuestion;
import com.univeris.cxp.questionnaire.Question;
import com.univeris.cxp.questionnaire.Section;

//@Scope(ScopeType.CONVERSATION)
@Name("answeredQuestionnaireAction")
public class AnsweredQuestionnaireAction
		extends
			AnsweredQuestionnaireActionBase implements java.io.Serializable {
	
	
	
	public void selectionChanged(){
		if(isNew()){
			
			if(getInstance().getAnsweredQuestions() != null)
				getInstance().getAnsweredQuestions().clear();
			else
				getInstance().setAnsweredQuestions(new ArrayList<AnsweredQuestion>());
				
			List<Section> sections = getInstance().getQuestionnaire().getSections();
			for (Section section : sections) {
				
				List<Question> questions = section.getQuestions();
				
				for (Question question : questions) {
					
					AnsweredQuestion aq = new AnsweredQuestion();
					aq.setQuestion(question);
					getInstance().addAnsweredQuestion(aq);
					
					if(aq.getAnswers() == null || aq.getAnswers().isEmpty()){
						aq.setAnswers(new ArrayList<Answer>());
						aq.addAnswer(new Answer());
					}
				}
				
			}
			
			
		}
	}
	
	
	@Override
	public String save() {
		
		return super.save();
	}


}
