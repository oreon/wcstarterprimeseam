<?xml version="1.0" encoding="UTF-8"?>

<ui:composition xmlns:ui="http://java.sun.com/jsf/facelets" xmlns="http://www.w3.org/1999/xhtml" xmlns:c="http://java.sun.com/jstl/core" xmlns:uvs="http://www.univeris.com/jsf/ewms/8.x" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:s="http://jboss.com/products/seam/taglib" xmlns:a="http://richfaces.org/a4j" xmlns:p="http://primefaces.prime.com.tr/ui" xmlns:rich="http://richfaces.org/rich">  
  <h:panelGroup id="panelEmployee" layout="block"> 
    <h:outputText value="#{uvs:label('GENDER')}"/>  
    <h:selectOneMenu id="gender" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('employee', 'editGender')}" value="#{employee.gender}" required="true" label="#{msg.person_gender}"> 
      <f:selectItem itemLabel="Please Select..." itemValue=""/>  
      <f:selectItem itemValue="MALE" itemLabel="#{msg.MALE}"/>  
      <f:selectItem itemValue="FEMALE" itemLabel="#{msg.FEMALE}"/> 
    </h:selectOneMenu>  
    <h:message for="gender"/>  
    <h:outputText value="#{uvs:label('DOB')}"/>  
    <p:calendar id="dob" value="#{employee.dob}" showOn="button"/>  
    <h:message for="dob"/>  
    <h:outputText value="#{uvs:label('DEPARTMENTID')}"/>  
    <h:selectOneMenu id="departmentId" value="#{employee.department}" required="true"> 
      <s:selectItems value="#{departmentList}" var="itemIter" label="#{itemIter.displayName}" noSelectionLabel="Please Select..."/>  
      <s:convertEntity/> 
    </h:selectOneMenu>  
    <h:message for="departmentId"/>  
    <h:outputText value="#{uvs:label('FIRSTNAME')}"/>  
    <h:inputText id="firstName" value="#{employee.firstName}"/>  
    <h:message for="firstName"/>  
    <h:outputText value="#{uvs:label('LASTNAME')}"/>  
    <h:inputText id="lastName" value="#{employee.lastName}"/>  
    <h:message for="lastName"/> 
  </h:panelGroup> 
</ui:composition>
