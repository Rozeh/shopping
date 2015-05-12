<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	function cart() {
		var qty =document.getElementById("qty").value;
		var no = document.getElementById("autono").value;
		var url="autotoolcart.do?autono="+no+"&qty="+qty;
		window.open(url, null, null, null);
	}

</script>


<body bgcolor="white">
	<center>
	<h2> 전동 공구 </h2>
	<form action="autotoolbuy.do" method="post">
	<table width="800" border="0" align="center">
	<tr  align="center"  >
		<td rowspan="4" width="300">
		<img alt="" src="img/${autobean.autoimg }" width="300">
		</td>
		<td align="center" width="100"><font size="2" color="white">공구이름 </font>  </td>
		<td align="center" width="150"><font size="2" color="white">${autobean.autoname }</font></td>
	</tr>
	<tr>
		<td align="center"><font size="2" color="white"> 구매수량 </font>  </td>
		<td align="center"><select name="autoqty" id="qty">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						   </select>  </td>
	</tr>
	<tr>
		<td align="center"><font size="2" color="white"> 판매금액 </font>  </td>
		<td align="center"><font size="2" color="white">${autobean.autoprice } </font> </td>
	</tr>
	<tr>		
		<td align="center" colspan="2"> 
		<input type="hidden" name="autonum" value="${autobean.autonum }" id="autono">
		<input type="hidden" name="autoimg" value="${autobean.autoimg }">
		<input type="hidden" name="autoprice" value="${autobean.autoprice }">
		<input type="button" 
		onclick="location.href='jundong.do'" value="목록보기"/> 
		<input type="button" onclick="cart()" value="카트담기"/> 
		<input type="submit" value="구매하기"> </td>
	</tr>
				
	</table>	
	</form>		
	</center>
	<p>
	<hr color="yellow"><font size="2" color="white">
	<b>상품 상세보기</b>
	<p>${autobean.autoinfo }</p></font>
</body>
</html>


