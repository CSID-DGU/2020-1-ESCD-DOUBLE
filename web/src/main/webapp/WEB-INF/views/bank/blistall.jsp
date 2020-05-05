<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/customize.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="resources/js/bootstrap.js"></script>

<meta charset="EUC-KR">
<title>Insert title here</title>
<style>

blockquote{
background:#f9f9f9;
border-left:10px solid #cccccc;
margin: 1.5em 10px;
padding: 0.5em 10px;
quotes: "\201C""\201D""\2018""\2019"
}
blockquote:before{
color:#cccccc;
content:open-quote;
font-size:3em;
line-height:0.1em;
margin-left:0.25em;
vertical-align:-0.4em;
}
blockquote:after{
color:#cccccc;
content:close-quote;
font-size:3em;
line-height:0.1em;
margin-left:0.25em;
vertical-align:-0.4em;
}


</style>
</head>
<body>  

<%@include file="../template/header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-xs-12">
		<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">
				<span class="glyphicon glyphicon-tags"></span>
				&nbsp;&nbsp;�л� ȸ�� ����
			</h3>
		</div>
	
		<table class="table">
			<thead>
			  <tr>
  				<td colspan="5" align="right"> �� ���� ��� : <b>${totalCount }</b>��
  			</tr>
			<tr>
			<th>��¥</th>	<th>�ܾ�</th>	<th>�����</th>	<th>��� �ݾ�</th><th>����</th><th>����</th>
			</tr>
			</thead>
			<tbody>
	  <c:if test="${!empty bl }">
   <c:forEach var= "list" items="${bl }">
   <tr>
    <th>${list.getBdate() }</th><input type="hidden" name="Bdate">
    <th>${list.getBrest() }</th><input type="hidden" name="Brest">
    <th>${list.getBuser() }</th><input type="hidden" name="Buser">
    <th>${list.getBinout() }</th><input type="hidden" name="Binout">
    <th>${list.getBmemo() }</th><input type="hidden" name="Bmemo">
    <th><a href="/web/downloadFile?fname=${list.getFname() }  ">${list.getFname() }  </a><br>
    

    </th>
  </tr></c:forEach></c:if>
  
    <c:if test="${empty bl }">
  <tr>
   <th colspan="5">�Խ��� ����� �����ϴ�!</th></tr></c:if>
			</tbody>
	<center><tr>
   		<th colspan="5">
   			<c:if test="${page<=1 }">
   				[����]&nbsp;
   			</c:if>
   			<c:if test="${page>1 }">
   				<a href="/web/blistall?page=${page-1 }">[����]</a>&nbsp;
   			</c:if>
   			
   			<%--������ ��ȣ ��� --%>
   			<c:forEach var="a" begin="${startpage }" end="${endpage }" step="1">
   				<c:if test="${a==page }"><%--���� �ʹ�ȣ�� ���õ� ���� ��ũ ����� --%>
   					 <${a }>
   				</c:if>
   				<c:if test="${a!=page}">
   					<a href="/web/blistall?page=${a }">[${a }]</a>&nbsp;
   					
   				</c:if>
   			</c:forEach>
   			<c:if test="${page>=endpage }"><!-- maxpage =>endpage�ιٲٸ�..? -->
   			[����]
   			</c:if>
   			<c:if test="${page<endpage }">
   			<a href="/web/blistall?page=${page+1 }">[����]</a>
   			</c:if>
   			
   		</th>
   </tr></center>
		</table>
			<div class="panel-footer">
					<blockquote>�ݰ���</blockquote>
			</div>
		
		</div></div>
	</div>
</div>


<%@include file="../template/footer.jsp"%>
</body>
</html>