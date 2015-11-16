<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.employee-resources"/>
<a href="${pageContext.request.contextPath}/indexEmployee"><span><fmt:message key="navigation.view"/> <fmt:message key="employee.title"/>s</span></a>
