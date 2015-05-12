<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

 <c:if test = "${msg == 1 }"> 
 <script type = "text/javascript">
 
  alert("비밀번호가 틀립니다.");
 
 </script>
 </c:if>
 <c:if test = "${msg == 2 }"> 
 <script type = "text/javascript">
 
  alert("회원 가입후 구매가 가능 합니다.");
 
 </script>
 </c:if>
 
 
 
 <center>
 <h2><font size="5" color="white">회원 가입</font> </h2>
 
 <form action = "joinproc.do" method = "post">
 
 <table width = "800" border = "0"  cellspacing = "1" cellpadding = "4">
 
 <tr  width = "30" height="40">
  <td align = "center" width = "180"> <font color = "#fffefa"> 아이디 </font></td>
  <td width = "220">
   <input type = "text" name = "memid" size = "20">
  </td>
 </tr> 
  
 <tr  width = "30" height="40">
  <td align = "center" width = "180"><font color = "#fffefa"> 패스워드 </font></td>
  <td width = "220">
   <input type = "text" name = "passwd1" size = "20">
  </td>
 </tr>
 
 <tr width = "30" height="40">
  <td align = "center" width = "180"><font color = "#fffefa"> 패스워드 확인 </font></td>
  <td width = "220">
   <input type = "text" name = "passwd2" size = "20">
  </td>
 </tr>
 
 <tr  width = "30" height="40">
  <td align = "center" width = "180"><font color = "#fffefa"> 이름 </font></td>
  <td width = "220">
   <input type = "text" name = "name" size = "20">
  </td>
 </tr>
 
 <tr width = "30" height="40">
  <td align = "center" width = "180"><font color = "#fffefa"> 전화번호 </font></td>
  <td width = "220">
   <input type = "text" name = "phone" size = "20">
  </td>
 </tr> 
  
 <tr  width = "30" height="40">
  <td align = "center" width = "180"><font color = "#fffefa"> 주소 </font></td>
  <td width = "220">
   <input type = "text" name = "address" size = "20">
  </td>
 </tr> 
 
 <tr width = "30" height="40">
  <td align = "center" width = "180"><font color = "#fffefa"> 생녕월일 </font></td>
  <td width = "220">
   <input type = "date" name = "birthday" size = "20">
  </td>
 </tr>
 
 <tr  width = "30" height="40">
  <td align = "center" width = "180"><font color = "#fffefa"> EMail </font></td>
  <td width = "220">
   <input type = "email" name = "email" size = "20">
  </td>
 </tr>
 
 <tr  width = "30" height="40">
  <td align = "center" width = "180"><font color = "#fffefa"> 성별 </font></td>
  <td width = "220">
   <select name = "gender">
    <option value = "m">남자</option>
    <option value = "f">여자</select>
   </select>
  </td>
 </tr>
 
 <tr  width = "30" height="40">
  <td align = "center" width = "180"><font color = "#fffefa"> 직업 </font></td>
  <td width = "250"><input type = "text" name = "job" size = "30"></td>
 </tr>
 
 <tr  width = "30" height="40">
  <td colspan = "2" align = "center">
  <input type = "submit" value = "회원가입">
  <input type = "reset" value = "다시작성">
  </td>
 </tr> 
 
 </table></form>
 
 </center>
</body>
</html>
