<?xml version="1.0" encoding="UTF-8"?>

<ui:composition xmlns:ui="http://java.sun.com/jsf/facelets" xmlns="http://www.w3.org/1999/xhtml" xmlns:c="http://java.sun.com/jstl/core" xmlns:uvs="http://www.univeris.com/jsf/ewms/8.x" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:s="http://jboss.com/products/seam/taglib" xmlns:a="http://richfaces.org/a4j" xmlns:p="http://primefaces.prime.com.tr/ui" xmlns:rich="http://richfaces.org/rich">  
  <h:panelGroup id="panelQuestion" layout="block"> 
    <h:outputText value="#{uvs:label('TEXT')}"/>  
    <h:inputTextarea id="text" value="#{question.text}" cols="55" rows="5" maxlength="800"/>  
    <h:message for="text"/>  
    <h:outputText value="#{uvs:label('SECTIONID')}"/>  
    <h:selectOneMenu id="sectionId" value="#{question.section}" required="true"> 
      <s:selectItems value="#{sectionList}" var="itemIter" label="#{itemIter.displayName}" noSelectionLabel="Please Select..."/>  
      <s:convertEntity/> 
    </h:selectOneMenu>  
    <h:message for="sectionId"/>  
    <h:outputText value="#{uvs:label('ANSWERTYPE')}"/>  
    <h:selectOneMenu id="answerType" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('question', 'editAnswerType')}" value="#{question.answerType}" required="false" label="#{msg.question_answerType}"> 
      <f:selectItem itemLabel="Please Select..." itemValue=""/>  
      <f:selectItem itemValue="SINGLE" itemLabel="#{msg.SINGLE}"/>  
      <f:selectItem itemValue="MULTIPLE" itemLabel="#{msg.MULTIPLE}"/> 
    </h:selectOneMenu>  
    <h:message for="answerType"/> 
  </h:panelGroup>  
  <a:commandButton value="New Answer" action="#{questionAction.addAnswers}" reRender="answers, editQuestionComponentPanel" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('question', 'editAnswers')}"> 
    <s:conversationId/> 
  </a:commandButton>  
  <rich:dataTable id="answers" var="answer" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('question', 'editAnswers')}" value="#{questionAction.listAnswers}" rowKeyVar="rowIndex" rowClasses="odd, even" styleClass="viewInfo" rules="all"> 
    <rich:column> 
      <f:facet name="header"> 
        <h:outputText value="#{msg.answer_question}  " rendered="#{skipPermissionCheck == 'true' || s:hasPermission('answer', 'viewQuestion')}"/> 
      </f:facet>  
      <h:selectOneMenu id="questionId" value="#{answer.question}" required="true"> 
        <s:selectItems value="#{questionList}" var="itemIter" label="#{itemIter.displayName}" noSelectionLabel="Please Select..."/>  
        <s:convertEntity/> 
      </h:selectOneMenu>  
      <h:message for="questionId"/> 
    </rich:column>  
    <rich:column> 
      <f:facet name="header"> 
        <h:outputText value="#{msg.answer_text}  " rendered="#{skipPermissionCheck == 'true' || s:hasPermission('answer', 'viewText')}"/> 
      </f:facet>  
      <h:inputTextarea id="text" value="#{answer.text}" cols="55" rows="5" maxlength="800"/>  
      <h:message for="text"/> 
    </rich:column>  
    <rich:column> 
      <f:facet name="header"> 
        <h:outputText value="#{msg.answer_score}  " rendered="#{skipPermissionCheck == 'true' || s:hasPermission('answer', 'viewScore')}"/> 
      </f:facet>  
      <h:inputText id="score" value="#{answer.score}"/>  
      <h:message for="score"/> 
    </rich:column>  
    <h:column> 
      <a:commandButton value="New Answer" action="#{questionAction.addAnswers}" reRender="answers, editQuestionComponentPanel" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('answer', 'editAnswers')}"> 
        <s:conversationId/> 
      </a:commandButton> 
    </h:column>  
    <h:column> 
      <h:commandButton value="Delete" immediate="true" action="#{questionAction.deleteAnswers(rowIndex)}" reRender="answers"> 
        <s:conversationId/> 
      </h:commandButton> 
    </h:column> 
  </rich:dataTable> 
</ui:composition>
