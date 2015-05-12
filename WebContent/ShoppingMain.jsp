<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body bgcolor="black">
<center>
	<!-- 파라미터를 통해서 center값을 읽어드림  -->
	<c:set var="center" value="${center }" />
	<c:set var="left" value="${left }" />
	<!-- 만약 CarMain.jsp를 처음 실행한다면 center값이 null이기에
	초기값으로 우리가 만든 Center.jsp를 설정   -->
	<c:if test="${center==null }">
		<c:set var="center"  value="Center.jsp" />
	</c:if>	
	<table width="1000" >
	<tr height="80" align="center" >
		<td align="center" colspan="2">	<jsp:include page="Top.jsp"/></td>
	</tr>
	<tr height="470" align="center" valign="top">
		<c:if test="${left==null }">
		<td align="center">	<jsp:include page="${center }"/></td>
		</c:if>
		<c:if test="${left!=null }">
		<td align="center" width="200">	<jsp:include page="${left }"/></td>
		<td align="center" width="800"> <jsp:include page="${center }"/></td>
		</c:if>
	</tr>
	<tr height="80" align="center">
		<td align="center" colspan="2">	<jsp:include page="Bottom.jsp"/></td>
	</tr>
	</table>

</center></body>
</html>




