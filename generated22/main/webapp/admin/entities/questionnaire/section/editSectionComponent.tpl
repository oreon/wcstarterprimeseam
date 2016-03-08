<?xml version="1.0" encoding="UTF-8"?>

<ui:composition xmlns:ui="http://java.sun.com/jsf/facelets" xmlns="http://www.w3.org/1999/xhtml" xmlns:c="http://java.sun.com/jstl/core" xmlns:uvs="http://www.univeris.com/jsf/ewms/8.x" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:s="http://jboss.com/products/seam/taglib" xmlns:a="http://richfaces.org/a4j" xmlns:p="http://primefaces.prime.com.tr/ui" xmlns:rich="http://richfaces.org/rich">  
  <h:panelGroup id="panelSection" layout="block"> 
    <h:outputText value="#{uvs:label('NAME')}"/>  
    <h:inputText id="name" value="#{section.name}"/>  
    <h:message for="name"/>  
    <h:outputText value="#{uvs:label('QUESTIONNAIREID')}"/>  
    <h:selectOneMenu id="questionnaireId" value="#{section.questionnaire}" required="true"> 
      <s:selectItems value="#{questionnaireList}" var="itemIter" label="#{itemIter.displayName}" noSelectionLabel="Please Select..."/>  
      <s:convertEntity/> 
    </h:selectOneMenu>  
    <h:message for="questionnaireId"/> 
  </h:panelGroup>  
  <a:commandButton value="New Question" action="#{sectionAction.addQuestions}" reRender="questions, editSectionComponentPanel" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('section', 'editQuestions')}"> 
    <s:conversationId/> 
  </a:commandButton>  
  <rich:dataTable id="questions" var="question" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('section', 'editQuestions')}" value="#{sectionAction.listQuestions}" rowKeyVar="rowIndex" rowClasses="odd, even" styleClass="viewInfo" rules="all"> 
    <rich:column> 
      <f:facet name="header"> 
        <h:outputText value="#{msg.question_text}  " rendered="#{skipPermissionCheck == 'true' || s:hasPermission('question', 'viewText')}"/> 
      </f:facet>  
      <h:inputTextarea id="text" value="#{question.text}" cols="55" rows="5" maxlength="800"/>  
      <h:message for="text"/> 
    </rich:column>  
    <rich:column> 
      <f:facet name="header"> 
        <h:outputText value="#{msg.question_section}  " rendered="#{skipPermissionCheck == 'true' || s:hasPermission('question', 'viewSection')}"/> 
      </f:facet>  
      <h:selectOneMenu id="sectionId" value="#{question.section}" required="true"> 
        <s:selectItems value="#{sectionList}" var="itemIter" label="#{itemIter.displayName}" noSelectionLabel="Please Select..."/>  
        <s:convertEntity/> 
      </h:selectOneMenu>  
      <h:message for="sectionId"/> 
    </rich:column>  
    <rich:column> 
      <f:facet name="header"> 
        <h:outputText value="#{msg.question_answerType}  " rendered="#{skipPermissionCheck == 'true' || s:hasPermission('question', 'viewAnswerType')}"/> 
      </f:facet>  
      <h:selectOneMenu id="answerType" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('question', 'editAnswerType')}" value="#{_question.answerType}" required="false" label="#{msg.question_answerType}"> 
        <f:selectItem itemLabel="Please Select..." itemValue=""/>  
        <f:selectItem itemValue="SINGLE" itemLabel="#{msg.SINGLE}"/>  
        <f:selectItem itemValue="MULTIPLE" itemLabel="#{msg.MULTIPLE}"/> 
      </h:selectOneMenu>  
      <h:message for="answerType"/> 
    </rich:column>  
    <h:column> 
      <a:commandButton value="New Question" action="#{sectionAction.addQuestions}" reRender="questions, editSectionComponentPanel" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('question', 'editQuestions')}"> 
        <s:conversationId/> 
      </a:commandButton> 
    </h:column>  
    <h:column> 
      <h:commandButton value="Delete" immediate="true" action="#{sectionAction.deleteQuestions(rowIndex)}" reRender="questions"> 
        <s:conversationId/> 
      </h:commandButton> 
    </h:column> 
  </rich:dataTable>  
  <a:commandButton value="New CategoryMappingEntry" action="#{sectionAction.addCategoryMappingEntrys}" reRender="categoryMappingEntrys, editSectionComponentPanel" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('question', 'editCategoryMappingEntrys')}"> 
    <s:conversationId/> 
  </a:commandButton>  
  <rich:dataTable id="categoryMappingEntrys" var="categoryMappingEntry" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('question', 'editCategoryMappingEntrys')}" value="#{sectionAction.listCategoryMappingEntrys}" rowKeyVar="rowIndex" rowClasses="odd, even" styleClass="viewInfo" rules="all"> 
    <rich:column> 
      <f:facet name="header"> 
        <h:outputText value="#{msg.mappingEntry_min}  " rendered="#{skipPermissionCheck == 'true' || s:hasPermission('categoryMappingEntry', 'viewMin')}"/> 
      </f:facet>  
      <h:inputText id="min" value="#{categoryMappingEntry.min}"/>  
      <h:message for="min"/> 
    </rich:column>  
    <rich:column> 
      <f:facet name="header"> 
        <h:outputText value="#{msg.mappingEntry_max}  " rendered="#{skipPermissionCheck == 'true' || s:hasPermission('categoryMappingEntry', 'viewMax')}"/> 
      </f:facet>  
      <h:inputText id="max" value="#{categoryMappingEntry.max}"/>  
      <h:message for="max"/> 
    </rich:column>  
    <rich:column> 
      <f:facet name="header"> 
        <h:outputText value="#{msg.mappingEntry_outcome}  " rendered="#{skipPermissionCheck == 'true' || s:hasPermission('categoryMappingEntry', 'viewOutcome')}"/> 
      </f:facet>  
      <h:selectOneMenu id="outcome" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('categoryMappingEntry', 'editOutcome')}" value="#{_categoryMappingEntry.outcome}" required="false" label="#{msg.mappingEntry_outcome}"> 
        <f:selectItem itemLabel="Please Select..." itemValue=""/>  
        <f:selectItem itemValue="VERY_CONSERVATIVE" itemLabel="#{msg.VERY_CONSERVATIVE}"/>  
        <f:selectItem itemValue="CONSERVATIVE" itemLabel="#{msg.CONSERVATIVE}"/>  
        <f:selectItem itemValue="GROWTH" itemLabel="#{msg.GROWTH}"/>  
        <f:selectItem itemValue="AGGRESSIVE_GROWTH" itemLabel="#{msg.AGGRESSIVE_GROWTH}"/> 
      </h:selectOneMenu>  
      <h:message for="outcome"/> 
    </rich:column>  
    <h:column> 
      <a:commandButton value="New CategoryMappingEntry" action="#{sectionAction.addCategoryMappingEntrys}" reRender="categoryMappingEntrys, editSectionComponentPanel" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('categoryMappingEntry', 'editCategoryMappingEntrys')}"> 
        <s:conversationId/> 
      </a:commandButton> 
    </h:column>  
    <h:column> 
      <h:commandButton value="Delete" immediate="true" action="#{sectionAction.deleteCategoryMappingEntrys(rowIndex)}" reRender="categoryMappingEntrys"> 
        <s:conversationId/> 
      </h:commandButton> 
    </h:column> 
  </rich:dataTable> 
</ui:composition>
