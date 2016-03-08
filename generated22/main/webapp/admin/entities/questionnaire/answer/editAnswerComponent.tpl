<?xml version="1.0" encoding="UTF-8"?>

<ui:composition xmlns:ui="http://java.sun.com/jsf/facelets" xmlns="http://www.w3.org/1999/xhtml" xmlns:c="http://java.sun.com/jstl/core" xmlns:uvs="http://www.univeris.com/jsf/ewms/8.x" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:s="http://jboss.com/products/seam/taglib" xmlns:a="http://richfaces.org/a4j" xmlns:p="http://primefaces.prime.com.tr/ui" xmlns:rich="http://richfaces.org/rich">  
  <h:panelGroup id="panelAnswer" layout="block"> 
    <h:outputText value="#{uvs:label('QUESTIONID')}"/>  
    <h:selectOneMenu id="questionId" value="#{answer.question}" required="true"> 
      <s:selectItems value="#{questionList}" var="itemIter" label="#{itemIter.displayName}" noSelectionLabel="Please Select..."/>  
      <s:convertEntity/> 
    </h:selectOneMenu>  
    <h:message for="questionId"/>  
    <h:outputText value="#{uvs:label('TEXT')}"/>  
    <h:inputTextarea id="text" value="#{answer.text}" cols="55" rows="5" maxlength="800"/>  
    <h:message for="text"/>  
    <h:outputText value="#{uvs:label('SCORE')}"/>  
    <h:inputText id="score" value="#{answer.score}"/>  
    <h:message for="score"/> 
  </h:panelGroup> 
</ui:composition>
