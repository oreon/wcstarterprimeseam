package com.oreon.cerebrum.web.action.investors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.primefaces.event.FlowEvent;

import com.oreon.cerebrum.web.action.commerce.CustomerAction;
import com.oreon.cerebrum.web.action.questionnaire.AnsweredQuestionnaireAction;
import com.univeris.cxp.commerce.Customer;
import com.univeris.cxp.questionnaire.Answer;
import com.univeris.cxp.questionnaire.AnsweredQuestion;
import com.univeris.cxp.questionnaire.AnsweredQuestionnaire;
import com.univeris.cxp.questionnaire.AnsweredQuestionnaireBase;
import com.univeris.cxp.questionnaire.Question;
import com.univeris.cxp.questionnaire.Section;


@Scope(ScopeType.PAGE)
@Name("investorFlowAction")
public class InvestorFlowAction implements Serializable{
	
	private Customer customer = new Customer();
	private AnsweredQuestionnaire answeredQuestionnaire = new AnsweredQuestionnaire();
	
	private String answer ;
	
	
	@In(create=true)
	AnsweredQuestionnaireAction answeredQuestionnaireAction;
	
	@In(create=true)
	CustomerAction customerAction;
	
	
	@Create
	public void initme(){
		//answeredQuestionnaire = answeredQuestionnaireAction.getInstance();
		//setCustomer(new Customer());
	}
	
	public String onFlowProcess(FlowEvent event) {
		/*
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {*/
            return event.getNewStep();
       // }
    }

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public AnsweredQuestionnaire getAnsweredQuestionnaire() {
		return answeredQuestionnaire;
	}

	public void setAnsweredQuestionnaire(AnsweredQuestionnaire answeredQuestionnaire) {
		this.answeredQuestionnaire = answeredQuestionnaire;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	public void selectionChanged(){
		if(null == answeredQuestionnaire.getId() ){
			
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
	
	
	private AnsweredQuestionnaire getInstance() {
		return answeredQuestionnaire;
	}

	//@Override
	public String save() {
		
		return "" ; // super.save();
	}

}
