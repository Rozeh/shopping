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
 
  alert("��й�ȣ�� Ʋ���ϴ�.");
 
 </script>
 </c:if>
 <c:if test = "${msg == 2 }"> 
 <script type = "text/javascript">
 
  alert("ȸ�� ������ ���Ű� ���� �մϴ�.");
 
 </script>
 </c:if>
 
 
 
 <center>
 <h2><font size="5" color="white">ȸ�� ����</font> </h2>
 
 <form action = "joinproc.do" method = "post">
 
 <table width = "800" border = "0"  cellspacing = "1" cellpadding = "4">
 
 <tr  width = "30" height="40">
  <td align = "center" width = "180"> <font color = "#fffefa"> ���̵� </font></td>
  <td width = "220">
   <input type = "text" name = "memid" size = "20">
  </td>
 </tr> 
  
 <tr  width = "30" height="40">
  <td align = "center" width = "180"><font color = "#fffefa"> �н����� </font></td>
  <td width = "220">
   <input type = "text" name = "passwd1" size = "20">
  </td>
 </tr>
 
 <tr width = "30" height="40">
  <td align = "center" width = "180"><font color = "#fffefa"> �н����� Ȯ�� </font></td>
  <td width = "220">
   <input type = "text" name = "passwd2" size = "20">
  </td>
 </tr>
 
 <tr  width = "30" height="40">
  <td align = "center" width = "180"><font color = "#fffefa"> �̸� </font></td>
  <td width = "220">
   <input type = "text" name = "name" size = "20">
  </td>
 </tr>
 
 <tr width = "30" height="40">
  <td align = "center" width = "180"><font color = "#fffefa"> ��ȭ��ȣ </font></td>
  <td width = "220">
   <input type = "text" name = "phone" size = "20">
  </td>
 </tr> 
  
 <tr  width = "30" height="40">
  <td align = "center" width = "180"><font color = "#fffefa"> �ּ� </font></td>
  <td width = "220">
   <input type = "text" name = "address" size = "20">
  </td>
 </tr> 
 
 <tr width = "30" height="40">
  <td align = "center" width = "180"><font color = "#fffefa"> ������� </font></td>
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
  <td align = "center" width = "180"><font color = "#fffefa"> ���� </font></td>
  <td width = "220">
   <select name = "gender">
    <option value = "m">����</option>
    <option value = "f">����</select>
   </select>
  </td>
 </tr>
 
 <tr  width = "30" height="40">
  <td align = "center" width = "180"><font color = "#fffefa"> ���� </font></td>
  <td width = "250"><input type = "text" name = "job" size = "30"></td>
 </tr>
 
 <tr  width = "30" height="40">
  <td colspan = "2" align = "center">
  <input type = "submit" value = "ȸ������">
  <input type = "reset" value = "�ٽ��ۼ�">
  </td>
 </tr> 
 
 </table></form>
 
 </center>
</body>
</html>
