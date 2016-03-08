<?xml version="1.0" encoding="UTF-8"?>

<ui:composition xmlns:ui="http://java.sun.com/jsf/facelets" xmlns="http://www.w3.org/1999/xhtml" xmlns:c="http://java.sun.com/jstl/core" xmlns:uvs="http://www.univeris.com/jsf/ewms/8.x" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:s="http://jboss.com/products/seam/taglib" xmlns:a="http://richfaces.org/a4j" xmlns:p="http://primefaces.prime.com.tr/ui" xmlns:rich="http://richfaces.org/rich">  
  <h:panelGroup id="panelQuestionnaireMappingEntry" layout="block"> 
    <h:outputText value="#{uvs:label('MIN')}"/>  
    <h:inputText id="min" value="#{questionnaireMappingEntry.min}"/>  
    <h:message for="min"/>  
    <h:outputText value="#{uvs:label('MAX')}"/>  
    <h:inputText id="max" value="#{questionnaireMappingEntry.max}"/>  
    <h:message for="max"/>  
    <h:outputText value="#{uvs:label('OUTCOME')}"/>  
    <h:selectOneMenu id="outcome" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('questionnaireMappingEntry', 'editOutcome')}" value="#{questionnaireMappingEntry.outcome}" required="false" label="#{msg.mappingEntry_outcome}"> 
      <f:selectItem itemLabel="Please Select..." itemValue=""/>  
      <f:selectItem itemValue="VERY_CONSERVATIVE" itemLabel="#{msg.VERY_CONSERVATIVE}"/>  
      <f:selectItem itemValue="CONSERVATIVE" itemLabel="#{msg.CONSERVATIVE}"/>  
      <f:selectItem itemValue="GROWTH" itemLabel="#{msg.GROWTH}"/>  
      <f:selectItem itemValue="AGGRESSIVE_GROWTH" itemLabel="#{msg.AGGRESSIVE_GROWTH}"/> 
    </h:selectOneMenu>  
    <h:message for="outcome"/> 
  </h:panelGroup> 
</ui:composition>
