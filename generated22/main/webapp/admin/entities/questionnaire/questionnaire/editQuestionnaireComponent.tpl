<?xml version="1.0" encoding="UTF-8"?>

<ui:composition xmlns:ui="http://java.sun.com/jsf/facelets" xmlns="http://www.w3.org/1999/xhtml" xmlns:c="http://java.sun.com/jstl/core" xmlns:uvs="http://www.univeris.com/jsf/ewms/8.x" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:s="http://jboss.com/products/seam/taglib" xmlns:a="http://richfaces.org/a4j" xmlns:p="http://primefaces.prime.com.tr/ui" xmlns:rich="http://richfaces.org/rich">  
  <h:panelGroup id="panelQuestionnaire" layout="block"> 
    <h:outputText value="#{uvs:label('NAME')}"/>  
    <h:inputText id="name" value="#{questionnaire.name}"/>  
    <h:message for="name"/> 
  </h:panelGroup>  
  <a:commandButton value="New Section" action="#{questionnaireAction.addSections}" reRender="sections, editQuestionnaireComponentPanel" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('questionnaire', 'editSections')}"> 
    <s:conversationId/> 
  </a:commandButton>  
  <rich:dataTable id="sections" var="section" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('questionnaire', 'editSections')}" value="#{questionnaireAction.listSections}" rowKeyVar="rowIndex" rowClasses="odd, even" styleClass="viewInfo" rules="all"> 
    <rich:column> 
      <f:facet name="header"> 
        <h:outputText value="#{msg.section_name}  " rendered="#{skipPermissionCheck == 'true' || s:hasPermission('section', 'viewName')}"/> 
      </f:facet>  
      <h:inputText id="name" value="#{section.name}"/>  
      <h:message for="name"/> 
    </rich:column>  
    <rich:column> 
      <f:facet name="header"> 
        <h:outputText value="#{msg.section_questionnaire}  " rendered="#{skipPermissionCheck == 'true' || s:hasPermission('section', 'viewQuestionnaire')}"/> 
      </f:facet>  
      <h:selectOneMenu id="questionnaireId" value="#{section.questionnaire}" required="true"> 
        <s:selectItems value="#{questionnaireList}" var="itemIter" label="#{itemIter.displayName}" noSelectionLabel="Please Select..."/>  
        <s:convertEntity/> 
      </h:selectOneMenu>  
      <h:message for="questionnaireId"/> 
    </rich:column>  
    <h:column> 
      <a:commandButton value="New Section" action="#{questionnaireAction.addSections}" reRender="sections, editQuestionnaireComponentPanel" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('section', 'editSections')}"> 
        <s:conversationId/> 
      </a:commandButton> 
    </h:column>  
    <h:column> 
      <h:commandButton value="Delete" immediate="true" action="#{questionnaireAction.deleteSections(rowIndex)}" reRender="sections"> 
        <s:conversationId/> 
      </h:commandButton> 
    </h:column> 
  </rich:dataTable>  
  <a:commandButton value="New QuestionnaireMappingEntry" action="#{questionnaireAction.addQuestionnaireMappingEntrys}" reRender="questionnaireMappingEntrys, editQuestionnaireComponentPanel" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('section', 'editQuestionnaireMappingEntrys')}"> 
    <s:conversationId/> 
  </a:commandButton>  
  <rich:dataTable id="questionnaireMappingEntrys" var="questionnaireMappingEntry" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('section', 'editQuestionnaireMappingEntrys')}" value="#{questionnaireAction.listQuestionnaireMappingEntrys}" rowKeyVar="rowIndex" rowClasses="odd, even" styleClass="viewInfo" rules="all"> 
    <rich:column> 
      <f:facet name="header"> 
        <h:outputText value="#{msg.mappingEntry_min}  " rendered="#{skipPermissionCheck == 'true' || s:hasPermission('questionnaireMappingEntry', 'viewMin')}"/> 
      </f:facet>  
      <h:inputText id="min" value="#{questionnaireMappingEntry.min}"/>  
      <h:message for="min"/> 
    </rich:column>  
    <rich:column> 
      <f:facet name="header"> 
        <h:outputText value="#{msg.mappingEntry_max}  " rendered="#{skipPermissionCheck == 'true' || s:hasPermission('questionnaireMappingEntry', 'viewMax')}"/> 
      </f:facet>  
      <h:inputText id="max" value="#{questionnaireMappingEntry.max}"/>  
      <h:message for="max"/> 
    </rich:column>  
    <rich:column> 
      <f:facet name="header"> 
        <h:outputText value="#{msg.mappingEntry_outcome}  " rendered="#{skipPermissionCheck == 'true' || s:hasPermission('questionnaireMappingEntry', 'viewOutcome')}"/> 
      </f:facet>  
      <h:selectOneMenu id="outcome" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('questionnaireMappingEntry', 'editOutcome')}" value="#{_questionnaireMappingEntry.outcome}" required="false" label="#{msg.mappingEntry_outcome}"> 
        <f:selectItem itemLabel="Please Select..." itemValue=""/>  
        <f:selectItem itemValue="VERY_CONSERVATIVE" itemLabel="#{msg.VERY_CONSERVATIVE}"/>  
        <f:selectItem itemValue="CONSERVATIVE" itemLabel="#{msg.CONSERVATIVE}"/>  
        <f:selectItem itemValue="GROWTH" itemLabel="#{msg.GROWTH}"/>  
        <f:selectItem itemValue="AGGRESSIVE_GROWTH" itemLabel="#{msg.AGGRESSIVE_GROWTH}"/> 
      </h:selectOneMenu>  
      <h:message for="outcome"/> 
    </rich:column>  
    <h:column> 
      <a:commandButton value="New QuestionnaireMappingEntry" action="#{questionnaireAction.addQuestionnaireMappingEntrys}" reRender="questionnaireMappingEntrys, editQuestionnaireComponentPanel" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('questionnaireMappingEntry', 'editQuestionnaireMappingEntrys')}"> 
        <s:conversationId/> 
      </a:commandButton> 
    </h:column>  
    <h:column> 
      <h:commandButton value="Delete" immediate="true" action="#{questionnaireAction.deleteQuestionnaireMappingEntrys(rowIndex)}" reRender="questionnaireMappingEntrys"> 
        <s:conversationId/> 
      </h:commandButton> 
    </h:column> 
  </rich:dataTable> 
</ui:composition>
