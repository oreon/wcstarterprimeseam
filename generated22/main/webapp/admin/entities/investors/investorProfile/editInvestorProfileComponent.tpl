<?xml version="1.0" encoding="UTF-8"?>

<ui:composition xmlns:ui="http://java.sun.com/jsf/facelets" xmlns="http://www.w3.org/1999/xhtml" xmlns:c="http://java.sun.com/jstl/core" xmlns:uvs="http://www.univeris.com/jsf/ewms/8.x" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:s="http://jboss.com/products/seam/taglib" xmlns:a="http://richfaces.org/a4j" xmlns:p="http://primefaces.prime.com.tr/ui" xmlns:rich="http://richfaces.org/rich">  
  <h:panelGroup id="panelInvestorProfile" layout="block"> 
    <h:outputText value="#{uvs:label('NAMEENG')}"/>  
    <h:inputText id="nameEng" value="#{investorProfile.nameEng}"/>  
    <h:message for="nameEng"/>  
    <h:outputText value="#{uvs:label('NAMEFRE')}"/>  
    <h:inputText id="nameFre" value="#{investorProfile.nameFre}"/>  
    <h:message for="nameFre"/>  
    <h:outputText value="#{uvs:label('DESCENG')}"/>  
    <h:inputTextarea id="descEng" value="#{investorProfile.descEng}" cols="55" rows="5" maxlength="800"/>  
    <h:message for="descEng"/>  
    <h:outputText value="#{uvs:label('DESCFRE')}"/>  
    <h:inputTextarea id="descFre" value="#{investorProfile.descFre}" cols="55" rows="5" maxlength="800"/>  
    <h:message for="descFre"/>  
    <h:outputText value="#{uvs:label('IMAGEFILEURI')}"/>  
    <h:inputText id="imageFileUri" value="#{investorProfile.imageFileUri}"/>  
    <h:message for="imageFileUri"/>  
    <h:outputText value="#{uvs:label('CONSERVATIVEORDER')}"/>  
    <h:inputText id="conservativeOrder" value="#{investorProfile.conservativeOrder}"/>  
    <h:message for="conservativeOrder"/> 
  </h:panelGroup> 
</ui:composition>
