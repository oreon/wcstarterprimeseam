<?xml version="1.0" encoding="UTF-8"?>

<ui:composition xmlns:ui="http://java.sun.com/jsf/facelets" xmlns:c="http://java.sun.com/jstl/core" xmlns:uvs="http://www.univeris.com/jsf/ewms/8.x" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:s="http://jboss.com/products/seam/taglib" xmlns:a="http://richfaces.org/a4j" xmlns:p="http://primefaces.prime.com.tr/ui" xmlns:rich="http://richfaces.org/rich" template="/layout/stub/clientXpress.seam">  
  <!--selected script/css includes file-->  
  <ui:param name="layout_jsIncludes" value="/layout/scripts/cxpImports.seam"/>  
  <!--selected tab template file-->  
  <ui:param name="layout_tabTemplate" value="/layout/menu/tabSelectionOperations.seam"/>  
  <!--selected left nav template file-->  
  <ui:param name="layout_navTemplate" value="/layout/menu/nav/operationsClientXpressProfile.seam"/>  
  <ui:param name="layout_pageTitle" value="#{uvs:label('PROFILES')}"/>  
  <ui:param name="step" value="library"/>  
  <ui:define name="page-header"> 
    <ui:include src="/cxp/operations/controls/clientProfileTabs.seam"/> 
  </ui:define>  
  <ui:define name="page-content"> 
    <ui:include src="editCustomerOrderComponent.tpl"/> 
  </ui:define> 
</ui:composition>
