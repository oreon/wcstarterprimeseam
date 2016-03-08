<?xml version="1.0" encoding="UTF-8"?>

<ui:composition xmlns:ui="http://java.sun.com/jsf/facelets" xmlns="http://www.w3.org/1999/xhtml" xmlns:c="http://java.sun.com/jstl/core" xmlns:uvs="http://www.univeris.com/jsf/ewms/8.x" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:s="http://jboss.com/products/seam/taglib" xmlns:a="http://richfaces.org/a4j" xmlns:p="http://primefaces.prime.com.tr/ui" xmlns:rich="http://richfaces.org/rich">  
  <uvs:secured fsaid="20000" access-type="8"> 
    <h:panelGroup id="panelProfiles" layout="block"> 
      <rich:datascroller for="recordsTable" maxpages="10" id="dsTop" fastcontrols="hide" renderifsinglepage="false" rerender="dsBtm"/>  
      <rich:dataTable id="recordsTable" rows="10" value="#{customerOrderAction.all}" var="customerOrder" style="border-right:solid 1px #c4c0c9;" headerClass="lj" columnClasses="autoWrapText bottomBorderOnly, autoWrapText bottomBorderOnly, autoWrapText bottomBorderOnly, autoWrapText bottomBorderOnly"> 
        <rich:column sortBy="#{record.notes}"> 
          <f:facet name="header">#{uvs:label('NOTES')}</f:facet>  
          <h:outputText value="#{customerOrder.notes}" escape="false"/> 
        </rich:column>  
        <rich:column sortBy="#{record.customer}"> 
          <f:facet name="header">#{uvs:label('CUSTOMER')}</f:facet>  
          <s:link escape="false" value="#{customerOrder.customer.displayName}" view="/admin/entities/commerce/customer/viewCustomer.xhtml" propagation="none"> 
            <f:param name="customerId" value="#{customerOrder.customer.id}"/>  
            <f:param name="from" value="#{request.servletPath}"/> 
          </s:link> 
        </rich:column>  
        <rich:column sortBy="#{record.shipDate}"> 
          <f:facet name="header">#{uvs:label('SHIPDATE')}</f:facet>  
          <h:outputText value="#{customerOrder.shipDate}"> 
            <s:convertDateTime type="date" dateStyle="medium"/> 
          </h:outputText> 
        </rich:column>  
        <rich:column sortBy="#{record.paymentMethod}"> 
          <f:facet name="header">#{uvs:label('PAYMENTMETHOD')}</f:facet>  
          <s:link escape="false" value="#{customerOrder.paymentMethod.displayName}" view="/admin/entities/commerce/paymentMethod/viewPaymentMethod.xhtml" propagation="none"> 
            <f:param name="paymentMethodId" value="#{customerOrder.paymentMethod.id}"/>  
            <f:param name="from" value="#{request.servletPath}"/> 
          </s:link> 
        </rich:column>  
        <rich:column> 
          <f:facet name="header"></f:facet>  
          <uvs:secured fsaid="20000" access-type="2"> 
            <h:commandLink action="#{customerOrderAction.delete(profile.code)}" title="#{uvs:label('DELETE')}" onmouseout="elem('img_#{profile.code}').src='#{uvs:nonJsfServletPath()}/files/cob/del_inactive.png'" onmouseover="elem('img_#{profile.code}').src='#{uvs:nonJsfServletPath()}/files/cob/del_active.png'" onclick="if(confirm(&quot;#{uvs:label(&quot;CONFIRM_DELETE_CLIENT_PROFILE_FROM_LIST&quot;)}&quot;)) return true; else return false;"> 
              <img id="img_#{profile.code}" src="#{uvs:nonJsfServletPath()}/files/cob/del_inactive.png"/> 
            </h:commandLink> 
          </uvs:secured> 
        </rich:column> 
      </rich:dataTable> 
    </h:panelGroup> 
  </uvs:secured> 
</ui:composition>
