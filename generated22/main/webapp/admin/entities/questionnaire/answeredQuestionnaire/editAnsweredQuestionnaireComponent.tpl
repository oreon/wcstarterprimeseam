<?xml version="1.0" encoding="UTF-8"?>

<ui:composition xmlns:ui="http://java.sun.com/jsf/facelets" xmlns="http://www.w3.org/1999/xhtml" xmlns:c="http://java.sun.com/jstl/core" xmlns:uvs="http://www.univeris.com/jsf/ewms/8.x" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:s="http://jboss.com/products/seam/taglib" xmlns:a="http://richfaces.org/a4j" xmlns:p="http://primefaces.prime.com.tr/ui" xmlns:rich="http://richfaces.org/rich">  
  <h:panelGroup id="panelAnsweredQuestionnaire" layout="block"> 
    <h:outputText value="#{uvs:label('QUESTIONNAIREID')}"/>  
    <h:selectOneMenu id="questionnaireId" value="#{answeredQuestionnaire.questionnaire}" required="true"> 
      <s:selectItems value="#{questionnaireList}" var="itemIter" label="#{itemIter.displayName}" noSelectionLabel="Please Select..."/>  
      <s:convertEntity/> 
    </h:selectOneMenu>  
    <h:message for="questionnaireId"/>  
    <h:outputText value="#{uvs:label('CUSTOMERID')}"/>  
    <h:selectOneMenu id="customerId" value="#{answeredQuestionnaire.customer}" required="true"> 
      <s:selectItems value="#{customerList}" var="itemIter" label="#{itemIter.displayName}" noSelectionLabel="Please Select..."/>  
      <s:convertEntity/> 
    </h:selectOneMenu>  
    <h:message for="customerId"/>  
    <h:outputText value="#{uvs:label('REMARKS')}"/>  
    <h:inputTextarea id="remarks" value="#{answeredQuestionnaire.remarks}" cols="55" rows="5" maxlength="800"/>  
    <h:message for="remarks"/> 
  </h:panelGroup>  
  <a:commandButton value="New AnsweredQuestion" action="#{answeredQuestionnaireAction.addAnsweredQuestions}" reRender="answeredQuestions, editAnsweredQuestionnaireComponentPanel" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('answeredQuestionnaire', 'editAnsweredQuestions')}"> 
    <s:conversationId/> 
  </a:commandButton>  
  <rich:dataTable id="answeredQuestions" var="answeredQuestion" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('answeredQuestionnaire', 'editAnsweredQuestions')}" value="#{answeredQuestionnaireAction.listAnsweredQuestions}" rowKeyVar="rowIndex" rowClasses="odd, even" styleClass="viewInfo" rules="all"> 
    <rich:column> 
      <f:facet name="header"> 
        <h:outputText value="#{msg.answeredQuestion_question}  " rendered="#{skipPermissionCheck == 'true' || s:hasPermission('answeredQuestion', 'viewQuestion')}"/> 
      </f:facet>  
      <h:selectOneMenu id="questionId" value="#{answeredQuestion.question}" required="true"> 
        <s:selectItems value="#{questionList}" var="itemIter" label="#{itemIter.displayName}" noSelectionLabel="Please Select..."/>  
        <s:convertEntity/> 
      </h:selectOneMenu>  
      <h:message for="questionId"/> 
    </rich:column>  
    <rich:column> 
      <f:facet name="header"> 
        <h:outputText value="#{msg.answeredQuestion_answeredQuestionnaire}  " rendered="#{skipPermissionCheck == 'true' || s:hasPermission('answeredQuestion', 'viewAnsweredQuestionnaire')}"/> 
      </f:facet>  
      <h:selectOneMenu id="answeredQuestionnaireId" value="#{answeredQuestion.answeredQuestionnaire}" required="true"> 
        <s:selectItems value="#{answeredQuestionnaireList}" var="itemIter" label="#{itemIter.displayName}" noSelectionLabel="Please Select..."/>  
        <s:convertEntity/> 
      </h:selectOneMenu>  
      <h:message for="answeredQuestionnaireId"/> 
    </rich:column>  
    <rich:column> 
      <f:facet name="header"> 
        <h:outputText value="#{msg.answeredQuestion_answer}  " rendered="#{skipPermissionCheck == 'true' || s:hasPermission('answeredQuestion', 'viewAnswer')}"/> 
      </f:facet>  
      <h:selectOneMenu id="answerId" value="#{answeredQuestion.answer}" required="false"> 
        <s:selectItems value="#{answerList}" var="itemIter" label="#{itemIter.displayName}" noSelectionLabel="Please Select..."/>  
        <s:convertEntity/> 
      </h:selectOneMenu>  
      <h:message for="answerId"/> 
    </rich:column>  
    <h:column> 
      <a:commandButton value="New AnsweredQuestion" action="#{answeredQuestionnaireAction.addAnsweredQuestions}" reRender="answeredQuestions, editAnsweredQuestionnaireComponentPanel" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('answeredQuestion', 'editAnsweredQuestions')}"> 
        <s:conversationId/> 
      </a:commandButton> 
    </h:column>  
    <h:column> 
      <h:commandButton value="Delete" immediate="true" action="#{answeredQuestionnaireAction.deleteAnsweredQuestions(rowIndex)}" reRender="answeredQuestions"> 
        <s:conversationId/> 
      </h:commandButton> 
    </h:column> 
  </rich:dataTable> 
</ui:composition>
