<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/customize.css">
<link rel="stylesheet" href="resources/css/template.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="resources/js/bootstrap.js"></script>
<script>

</script>

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

<body class="body">

<%@include file="../template/header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-xs-12">
		<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">
				<span class="glyphicon glyphicon-tags"></span>
				&nbsp;&nbsp;전 회원 조회
				
			</h3>
		</div>
	
		<table class="table">
			<thead>
			  <tr>
  				<td colspan="5" align="right"> 총 내역 목록 : <b>${totalCount }</b>개
  			</tr>
			<tr>
			<th>학번</th>	<th>전화번호</th>	<th>이름</th>	<th>전공</th><th>권한</th>
			</tr>
			</thead>
			<tbody>
	  <c:if test="${!empty alluser }">
	  
   <c:forEach var= "list" items="${alluser }">
<form action="chmod" method="post">
   <tr>  
    <th>${list.getSid() }<input type="hidden" name="Sid" value="${list.getSid() }"></th>
    <th>${list.getSnum() }<input type="hidden" name="Snum" value="${list.getSnum() }"></th>
    <th>${list.getSname() }<input type="hidden" name="Sname" value="${list.getSname() }"></th>
    <th>${list.getSmajor() }<input type="hidden" name="Smajor" value="${list.getSmajor() }"></th>
    <th>
    <c:if test="${list.getSiscouncil()==0 }">일반 학생</c:if>
    <c:if test="${list.getSiscouncil()==1 }">학생회</c:if>
    <c:if test="${list.getSiscouncil()==2 }">총무</c:if>
    
    </th>
    <th>
    
   <!--  <input type="text" name="Siscouncil" placeholder="${list.getSiscouncil() }"> -->
    <select name="Siscouncil">
    	<option value="0" selected>일반 학생</option>
    	<option value="1">학생회</option>
    	<option value="2">총무</option>
    </select>
    
    <input type="submit"></th>
  </tr> 
  </form>
  </c:forEach>
  </c:if>
  
    <c:if test="${empty alluser }">
  <tr>   <th colspan="5">게시판 목록이 없습니다!</th></tr></c:if>
			</tbody>
	
		</table>
		
		
		</div></div>
	</div>
</div>

<div class="footer">
<%@include file="../template/footer.jsp"%></div>
</body>
</html>