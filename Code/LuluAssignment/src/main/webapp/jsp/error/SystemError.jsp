<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isErrorPage="true" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Forex LuLu - Customer Registration</title>
	<link rel="stylesheet" type="text/css" media="screen" href='<s:url value="/css/error.css"/>' />
</head>
<body>
<%
	response.setStatus(500);
%>
<div id="errorAlignment">
<table id="report">
	<caption class="errorHeader">Unknown Exception - Please check with Administrator</caption>
	<tr>
		<th>Name</th>
		<th>Value</th>
	</tr>
	<tr>
		<td>Exception Details:</td>
		<td><s:property value="exceptionStack" /></td>
	</tr>
</table>
</div>
</body>
</html>
