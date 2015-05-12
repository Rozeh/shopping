<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<c:if test="${login==1 }">
	<script type="text/javascript">
		alert("아이디/패스워드를 확인하세요");
	</script>
</c:if>


<center><h2> 회원 로그인 </h2>
	<form action="loginproc.do" method="post">
	<table width="500">
	<tr height="40" >
		<td width="200" align="center"><font size="2" color="white"> 아이디 </font></td>	
		<td width="300" align="center"><input type="text" name="memid" size="30"></td>
	</tr>
	<tr height="40" align="center">
		<td width="200" align="center"><font size="2" color="white"> 패스워드 </font></td>	
		<td width="300" align="center"><input type="password" name="passwd" size="30"></td>
	</tr>
	<tr height="50">
		<td colspan="2" align="center">
		<input type="submit" value="로그인"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<font size="2" color="white">아이디/패스워드찾기</font></a>
		</td>
	</tr>	
	</table>
	</form>
</center>

</body>
</html>