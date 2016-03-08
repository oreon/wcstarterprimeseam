<?xml version="1.0" encoding="UTF-8"?>

<ui:composition xmlns:ui="http://java.sun.com/jsf/facelets" xmlns="http://www.w3.org/1999/xhtml" xmlns:c="http://java.sun.com/jstl/core" xmlns:uvs="http://www.univeris.com/jsf/ewms/8.x" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:s="http://jboss.com/products/seam/taglib" xmlns:a="http://richfaces.org/a4j" xmlns:p="http://primefaces.prime.com.tr/ui" xmlns:rich="http://richfaces.org/rich">  
  <h:panelGroup id="panelAnsweredQuestion" layout="block"> 
    <h:outputText value="#{uvs:label('QUESTIONID')}"/>  
    <h:selectOneMenu id="questionId" value="#{answeredQuestion.question}" required="true"> 
      <s:selectItems value="#{questionList}" var="itemIter" label="#{itemIter.displayName}" noSelectionLabel="Please Select..."/>  
      <s:convertEntity/> 
    </h:selectOneMenu>  
    <h:message for="questionId"/>  
    <h:outputText value="#{uvs:label('ANSWEREDQUESTIONNAIREID')}"/>  
    <h:selectOneMenu id="answeredQuestionnaireId" value="#{answeredQuestion.answeredQuestionnaire}" required="true"> 
      <s:selectItems value="#{answeredQuestionnaireList}" var="itemIter" label="#{itemIter.displayName}" noSelectionLabel="Please Select..."/>  
      <s:convertEntity/> 
    </h:selectOneMenu>  
    <h:message for="answeredQuestionnaireId"/>  
    <h:outputText value="#{uvs:label('ANSWERID')}"/>  
    <h:selectOneMenu id="answerId" value="#{answeredQuestion.answer}" required="false"> 
      <s:selectItems value="#{answerList}" var="itemIter" label="#{itemIter.displayName}" noSelectionLabel="Please Select..."/>  
      <s:convertEntity/> 
    </h:selectOneMenu>  
    <h:message for="answerId"/> 
  </h:panelGroup> 
</ui:composition>
