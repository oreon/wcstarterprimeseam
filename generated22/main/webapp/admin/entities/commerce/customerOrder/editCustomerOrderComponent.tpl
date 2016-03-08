<?xml version="1.0" encoding="UTF-8"?>

<ui:composition xmlns:ui="http://java.sun.com/jsf/facelets" xmlns="http://www.w3.org/1999/xhtml" xmlns:c="http://java.sun.com/jstl/core" xmlns:uvs="http://www.univeris.com/jsf/ewms/8.x" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:s="http://jboss.com/products/seam/taglib" xmlns:a="http://richfaces.org/a4j" xmlns:p="http://primefaces.prime.com.tr/ui" xmlns:rich="http://richfaces.org/rich">  
  <h:panelGroup id="panelCustomerOrder" layout="block"> 
    <h:outputText value="#{uvs:label('NOTES')}"/>  
    <h:inputTextarea id="notes" value="#{customerOrder.notes}" cols="55" rows="5" maxlength="800"/>  
    <h:message for="notes"/>  
    <h:outputText value="#{uvs:label('CUSTOMERID')}"/>  
    <h:selectOneMenu id="customerId" value="#{customerOrder.customer}" required="true"> 
      <s:selectItems value="#{customerList}" var="itemIter" label="#{itemIter.displayName}" noSelectionLabel="Please Select..."/>  
      <s:convertEntity/> 
    </h:selectOneMenu>  
    <h:message for="customerId"/>  
    <h:outputText value="#{uvs:label('SHIPDATE')}"/>  
    <p:calendar id="shipDate" value="#{customerOrder.shipDate}" showOn="button"/>  
    <h:message for="shipDate"/>  
    <h:outputText value="#{uvs:label('PAYMENTMETHODID')}"/>  
    <h:selectOneMenu id="paymentMethodId" value="#{customerOrder.paymentMethod}" required="false"> 
      <s:selectItems value="#{paymentMethodList}" var="itemIter" label="#{itemIter.displayName}" noSelectionLabel="Please Select..."/>  
      <s:convertEntity/> 
    </h:selectOneMenu>  
    <h:message for="paymentMethodId"/> 
  </h:panelGroup>  
  <a:commandButton value="New OrderItem" action="#{customerOrderAction.addOrderItems}" reRender="orderItems, editCustomerOrderComponentPanel" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('customerOrder', 'editOrderItems')}"> 
    <s:conversationId/> 
  </a:commandButton>  
  <rich:dataTable id="orderItems" var="orderItem" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('customerOrder', 'editOrderItems')}" value="#{customerOrderAction.listOrderItems}" rowKeyVar="rowIndex" rowClasses="odd, even" styleClass="viewInfo" rules="all"> 
    <rich:column> 
      <f:facet name="header"> 
        <h:outputText value="#{msg.orderItem_qty}  " rendered="#{skipPermissionCheck == 'true' || s:hasPermission('orderItem', 'viewQty')}"/> 
      </f:facet>  
      <h:inputText id="qty" value="#{orderItem.qty}"/>  
      <h:message for="qty"/> 
    </rich:column>  
    <rich:column> 
      <f:facet name="header"> 
        <h:outputText value="#{msg.orderItem_product}  " rendered="#{skipPermissionCheck == 'true' || s:hasPermission('orderItem', 'viewProduct')}"/> 
      </f:facet>  
      <h:selectOneMenu id="productId" value="#{orderItem.product}" required="true"> 
        <s:selectItems value="#{productList}" var="itemIter" label="#{itemIter.displayName}" noSelectionLabel="Please Select..."/>  
        <s:convertEntity/> 
      </h:selectOneMenu>  
      <h:message for="productId"/> 
    </rich:column>  
    <rich:column> 
      <f:facet name="header"> 
        <h:outputText value="#{msg.orderItem_customerOrder}  " rendered="#{skipPermissionCheck == 'true' || s:hasPermission('orderItem', 'viewCustomerOrder')}"/> 
      </f:facet>  
      <h:selectOneMenu id="customerOrderId" value="#{orderItem.customerOrder}" required="true"> 
        <s:selectItems value="#{customerOrderList}" var="itemIter" label="#{itemIter.displayName}" noSelectionLabel="Please Select..."/>  
        <s:convertEntity/> 
      </h:selectOneMenu>  
      <h:message for="customerOrderId"/> 
    </rich:column>  
    <h:column> 
      <a:commandButton value="New OrderItem" action="#{customerOrderAction.addOrderItems}" reRender="orderItems, editCustomerOrderComponentPanel" rendered="#{skipPermissionCheck == 'true' || s:hasPermission('orderItem', 'editOrderItems')}"> 
        <s:conversationId/> 
      </a:commandButton> 
    </h:column>  
    <h:column> 
      <h:commandButton value="Delete" immediate="true" action="#{customerOrderAction.deleteOrderItems(rowIndex)}" reRender="orderItems"> 
        <s:conversationId/> 
      </h:commandButton> 
    </h:column> 
  </rich:dataTable> 
</ui:composition>
