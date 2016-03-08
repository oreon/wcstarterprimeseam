<?xml version="1.0" encoding="UTF-8"?>

<ui:composition xmlns:ui="http://java.sun.com/jsf/facelets" xmlns="http://www.w3.org/1999/xhtml" xmlns:c="http://java.sun.com/jstl/core" xmlns:uvs="http://www.univeris.com/jsf/ewms/8.x" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:s="http://jboss.com/products/seam/taglib" xmlns:a="http://richfaces.org/a4j" xmlns:p="http://primefaces.prime.com.tr/ui" xmlns:rich="http://richfaces.org/rich">  
  <h:panelGroup id="panelInvestingGoal" layout="block"> 
    <h:outputText value="#{uvs:label('NAMEENG')}"/>  
    <h:inputText id="nameEng" value="#{investingGoal.nameEng}"/>  
    <h:message for="nameEng"/>  
    <h:outputText value="#{uvs:label('NAMEFRE')}"/>  
    <h:inputText id="nameFre" value="#{investingGoal.nameFre}"/>  
    <h:message for="nameFre"/>  
    <h:outputText value="#{uvs:label('IMAGEFILEIRI')}"/>  
    <h:inputText id="imageFileIri" value="#{investingGoal.imageFileIri}"/>  
    <h:message for="imageFileIri"/>  
    <h:outputText value="#{uvs:label('ISDEFAULT')}"/>  
    <h:selectBooleanCheckbox id="isDefault" value="#{investingGoal.isDefault}"/>  
    <h:message for="isDefault"/>  
    <h:outputText value="#{uvs:label('INVESTINGGOALPLANCODEID')}"/>  
    <h:selectOneMenu id="investingGoalPlanCodeId" value="#{investingGoal.investingGoalPlanCode}" required="true"> 
      <s:selectItems value="#{investingGoalPlanCodeList}" var="itemIter" label="#{itemIter.displayName}" noSelectionLabel="Please Select..."/>  
      <s:convertEntity/> 
    </h:selectOneMenu>  
    <h:message for="investingGoalPlanCodeId"/> 
  </h:panelGroup> 
</ui:composition>
