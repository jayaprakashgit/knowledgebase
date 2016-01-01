<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Management</title>
</head>
<body>
Language : <a href="?language=en">English</a> | <a href="?language=tl">Thailand</a> | <a href="?language=fr"> French </a>
<br/><br/>
<spring:message code="user.logged"/> : <sec:authentication property="name"/> <sec:authentication property="authorities"/>
<br/>
<a href="logout"><spring:message code="user.logout"/></a>
<a href="<c:url value="j_spring_security_logout" />" > Logout... </a>
<h1><spring:message code="student.title"/></h1>
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<form:form action="student.do" method="POST" commandName="student">
		<table>
			<tr>
				<td><spring:message code="student.id"/></td>
				<td><form:input path="studentId" /></td>
			</tr>
			<tr>
				<td><spring:message code="student.firstname"/></td>
				<td><form:input path="firstname" /></td>
			</tr>
			<tr>
				<td><spring:message code="student.lastname"/></td>
				<td><form:input path="lastname" /></td>
			</tr>
			<tr>
				<td><spring:message code="student.yearLevel"/></td>
				<td><form:input path="yearLevel" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="action" value="Add" />
					<input type="submit" name="action" value="Edit" />
					<input type="submit" name="action" value="Delete" />
					<input type="submit" name="action" value="Search" />
				</td>
			</tr>
		</table>
	</form:form>
</sec:authorize>
<br>
<table border="1">
	<th><spring:message code="student.id"/></th>
	<th><spring:message code="student.firstname"/></th>
	<th><spring:message code="student.lastname"/></th>
	<th><spring:message code="student.yearLevel"/></th>
	<c:forEach items="${studentList}" var="student">
		<tr>
			<td>${student.studentId}</td>
			<td>${student.firstname}</td>
			<td>${student.lastname}</td>
			<td>${student.yearLevel}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>