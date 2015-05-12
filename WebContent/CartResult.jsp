<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<center>
	<h2><font color="white"> 카트 내용 확인하기</font></h2>
	<table width="800" style="font-size:10pt; color: white;">
	<tr height="50">
		<td align="center" colspan="5"> <font color="yellow" size="3">
		카트에는 다음 상품이 들어 있습니다. </font></td>
	</tr>
	<tr height="40">
		<td align="center" width="200"><font size="2" color="white">상품이미지</font></td>
		<td align="center" width="150"><font size="2" color="white">상품명</font></td>
		<td align="center" width="100"><font size="2" color="white">상품가격</font></td>
		<td align="center" width="100"><font size="2" color="white">상품수량</font></td>
		<td align="center" width="150"><font size="2" color="white">상품총금액</font></td>
		<td align="center" width="100"><font size="2" color="white">취소</font></td>
	</tr>		
	<c:forEach items="${cart.itemlist }" var="item">
	<tr height="80">
		<td align="center"><img src="img/${item.suimg }" width="150" height="80"></td>
		<td align="center"><font size="2" color="white">${item.suname}</font></td>
		<td align="center"><font size="2" color="white">${item.suprice }원</font></td>
		<td align="center"><font size="2" color="white">${item.qty }개</font></td>
		<td align="center"><font size="2" color="white">${item.suprice*item.qty }원</font></td>
		<td align="center"><input type="button" value="카트삭제"
		 onclick="location.href='cartdel.do?name=${item.suname}'"> </td>
	</tr>
		
	</c:forEach>
	<tr height="70">
		<td align="center" colspan="5"><font size="3" color="white">${msg }</font></td>
	</tr>
	<tr height="50">
		<td align="center" colspan="5">
			<input type="button" onclick="location.href='index.do'" value="목록보기">
			&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" onclick="location.href='cartbuy.do'" value="계산하기">
		</td>
	</tr>		
	</table>
	
</center>

</body>
</html>