<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	function cart() {
		var qty =document.getElementById("qty").value;
		var no = document.getElementById("suno").value;
		var url="sutoolcart.do?no="+no+"&qty="+qty;
		window.open(url, null, null, null);
	}

</script>


<body bgcolor="white">
	<center>
	<h2> ���� ���� </h2>
	<form action="sutoolbuy.do" method="post">
	<table width="800" border="0" align="center">
	<tr  align="center"  >
		<td rowspan="4" width="300">
		<img alt="" src="img/${sbean.suimg }" width="300">
		</td>
		<td align="center" width="100"><font size="2" color="white">�����̸� </font>  </td>
		<td align="center" width="150"><font size="2" color="white">${sbean.suname }</font></td>
	</tr>
	<tr>
		<td align="center"><font size="2" color="white"> ���ż��� </font>  </td>
		<td align="center"><select name="suqty" id="qty">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						   </select>  </td>
	</tr>
	<tr>
		<td align="center"><font size="2" color="white"> �Ǹűݾ� </font>  </td>
		<td align="center"><font size="2" color="white">${sbean.suprice } </font> </td>
	</tr>
	<tr>		
		<td align="center" colspan="2"> 
		<input type="hidden" name="no" value="${sbean.no }" id="suno">
		<input type="hidden" name="suimg" value="${sbean.suimg }">
		<input type="hidden" name="suprice" value="${sbean.suprice }">
		<input type="button" 
		onclick="location.href='sujak.do'" value="��Ϻ���"/> 
		<input type="button" onclick="cart()" value="īƮ���"/> 
		<input type="submit" value="�����ϱ�"> </td>
	</tr>
				
	</table>	
	</form>		
	</center>
	<p>
	<hr color="yellow"><font size="2" color="white">
	<b>��ǰ �󼼺���</b>
	<p>${sbean.suinfo }</p></font>
</body>
</html>


