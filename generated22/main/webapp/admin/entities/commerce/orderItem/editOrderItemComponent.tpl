<?xml version="1.0" encoding="UTF-8"?>

<ui:composition xmlns:ui="http://java.sun.com/jsf/facelets" xmlns="http://www.w3.org/1999/xhtml" xmlns:c="http://java.sun.com/jstl/core" xmlns:uvs="http://www.univeris.com/jsf/ewms/8.x" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:s="http://jboss.com/products/seam/taglib" xmlns:a="http://richfaces.org/a4j" xmlns:p="http://primefaces.prime.com.tr/ui" xmlns:rich="http://richfaces.org/rich">  
  <h:panelGroup id="panelOrderItem" layout="block"> 
    <h:outputText value="#{uvs:label('QTY')}"/>  
    <h:inputText id="qty" value="#{orderItem.qty}"/>  
    <h:message for="qty"/>  
    <h:outputText value="#{uvs:label('PRODUCTID')}"/>  
    <h:selectOneMenu id="productId" value="#{orderItem.product}" required="true"> 
      <s:selectItems value="#{productList}" var="itemIter" label="#{itemIter.displayName}" noSelectionLabel="Please Select..."/>  
      <s:convertEntity/> 
    </h:selectOneMenu>  
    <h:message for="productId"/>  
    <h:outputText value="#{uvs:label('CUSTOMERORDERID')}"/>  
    <h:selectOneMenu id="customerOrderId" value="#{orderItem.customerOrder}" required="true"> 
      <s:selectItems value="#{customerOrderList}" var="itemIter" label="#{itemIter.displayName}" noSelectionLabel="Please Select..."/>  
      <s:convertEntity/> 
    </h:selectOneMenu>  
    <h:message for="customerOrderId"/> 
  </h:panelGroup> 
</ui:composition>
