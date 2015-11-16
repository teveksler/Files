<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.inventory-resources"/>
<a href="${pageContext.request.contextPath}/indexInventory"><span><fmt:message key="navigation.view"/> <fmt:message key="inventory.title"/></span></a>
