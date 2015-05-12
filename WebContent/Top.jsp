<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body bgcolor="black">
<center>

<table width="1000" background="img/aa.jpg" height="5" >
	<tr height="50">
		<td align="left" width="500" ><a href="ShoppingMain.jsp" >
		<img alt="" src="img/logo.JPG" border="0" align="left"> </a>
		</td>
		<c:set var="mbean"  value="${mbean}" />
		
		<c:if test="${mbean==null }">
		<td align="right" width="300" >
		<input type="button" onclick="location.href='login.do'" value="로그인">
		&nbsp;&nbsp;&nbsp;
		<input type="button" onclick="location.href='joinform.do'" value="회원가입">		 
		</td>		
		</c:if>
		<c:if test="${mbean!=null }">
		<td align="right" width="300" >
		<font size="3" color="white"> ${mbean.memid } 님 환영 합니다.</font>&nbsp;&nbsp;
		<input type="button" value="로그아웃" onclick="location.href='logout.do'">
		</td>
		</c:if>
		
		<form action="mainsearch.do"  method="post">
		<td align="right" width="200" >
			<input type="text" name="msearch" size="10" >
			<input type="submit" value="검색">
		</td>
		</form>
	</tr>
</table>
<table width="1000" background="img/aa.jpg" height="5" >	
		<td align="center" bgcolor="black"><a href="sujak.do">
		<img src="img/sujak.JPG" ></a></td>
		<td  align="center" bgcolor="black"><a href="jundong.do">
		<img src="img/jundong.JPG"></a></td>
		<td  align="center" bgcolor="black"><a href="stanlyinfo.do">
		<img src="img/stanlyinfo.JPG" ></a></td>
		<td  align="center" bgcolor="black"><a href="tooluse.do">
		<img src="img/tooluse.JPG" ></a></td>
		<td  align="center" bgcolor="black"><a href="AdminBoardListController.do">
		<img src="img/download.JPG"></a></td>
		<td  align="center" bgcolor="black"><a href="AdminBoardListController.do">
		<img src="img/gogak.JPG"></a></td>
	</tr>	
</table>

</center>
	

</body>
</html>