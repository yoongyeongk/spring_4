<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<table>
		<tr>
			<td>ID</td>
			<td>PW</td>
			<td>Name</td>
			<td>Phone</td>
			<td>Email</td>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.id}</td>
			<td>${dto.pw}</td>
			<td>${dto.name}</td>
			<td>${dto.phone}</td>
			<td>${dto.email}</td>
		</tr>
		</c:forEach>
	</table>
