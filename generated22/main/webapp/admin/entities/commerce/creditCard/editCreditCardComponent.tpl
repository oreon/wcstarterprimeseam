<?xml version="1.0" encoding="UTF-8"?>

<ui:composition xmlns:ui="http://java.sun.com/jsf/facelets" xmlns="http://www.w3.org/1999/xhtml" xmlns:c="http://java.sun.com/jstl/core" xmlns:uvs="http://www.univeris.com/jsf/ewms/8.x" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:s="http://jboss.com/products/seam/taglib" xmlns:a="http://richfaces.org/a4j" xmlns:p="http://primefaces.prime.com.tr/ui" xmlns:rich="http://richfaces.org/rich">  
  <h:panelGroup id="panelCreditCard" layout="block"> 
    <h:outputText value="#{uvs:label('ACCOUNTADDRESS')}"/>  
    <h:inputText id="accountAddress" value="#{creditCard.accountAddress}"/>  
    <h:message for="accountAddress"/>  
    <h:outputText value="#{uvs:label('CCNUMBER')}"/>  
    <h:inputText id="ccNumber" value="#{creditCard.ccNumber}"/>  
    <h:message for="ccNumber"/>  
    <h:outputText value="#{uvs:label('EXPIRY')}"/>  
    <p:calendar id="expiry" value="#{creditCard.expiry}" showOn="button"/>  
    <h:message for="expiry"/> 
  </h:panelGroup> 
</ui:composition>
