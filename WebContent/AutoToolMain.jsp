<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<table width="800" border="0" height="470">
	<c:set var="j" value="0"/>
     <c:forEach var="v" items="${v}">       
     <c:if test="${j%4==0 }">
     <tr align="center">
     </c:if>
       <td width="200" height="300" valign="top"><a href="autoinfo.do?no=${v.autonum}">
       		 <img width="195" height="180" src="img/${v.autoimg }"></a> <p> 
        <font color="white" size="2">    ������ : ${v.autoname }  <br> 
            �Ǹűݾ� : ${v.autoprice}         </font>   
      </td>
          
     
      <c:set var="j" value="${j+1 }"/>
    </c:forEach>
    
	</table>
	</form>

</body>
</html>



