<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

 <style type="text/css">
<%@ include file="/views/CssStyle/Style1.css" %>
</style>


</head>
<body >
<%@ include file="/views/navbar/NavBarUser.jsp" %>

<%-- Slider --%>
<div id="carouselExample d-sm-none" class="carousel slide">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="/ReupTrailerMovie/imgAsmJava/panda.png" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/ReupTrailerMovie/imgAsmJava/panda.png" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/ReupTrailerMovie/imgAsmJava/panda.png" class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>

<%-- Button --%>
<div class="container mx-auto row my-3 ">

</div>

<%-- container movie render and top view movie --%>

<div class="row bodyContent h-100" >

<%--Movie render --%>
<div class="col-9 ">
<h4 class="ms-3 text-white">Movie</h4>
	<div  class="row mx-auto">
	
		<c:forEach var="i" begin="0" end="${7}" step="1">
		<div class="col-sm-6 col-md-4 col-lg-3  col-sx-12 ">
		
		<c:if test="${listVideo[i+ ListEnd]!=null}">
		<jsp:include page="./Movie/MovieRender.jsp">
			<jsp:param value="${listVideo[i + ListEnd].title}" name="title"/>
			<jsp:param value="${listVideo[i + ListEnd].poster}" name="poster"/>
			<jsp:param value="${listVideo[i + ListEnd].idVideo}" name="idVideo"/>
		
		</jsp:include>
		</c:if>
		</div>
		</c:forEach>
		
	
	</div>
	
	<div class=" w-100  d-flex justify-content-center">
			<div class="mx-auto">
<nav aria-label="Page navigation example">
  <ul class="pagination">
  	<c:set var="maxPage" value="0"></c:set>
    <li class="page-item"><a class="page-link" href="/ReupTrailerMovie/Home/page?numPage=${CurrentPage>1?CurrentPage-1:1}">Previous</a></li>
    
    
    <c:forEach var="i" begin="0" end="${fn:length(listVideo) /8}" step="1">
    <li class="page-item"><a class="page-link" href="/ReupTrailerMovie/Home/page?numPage=${i+1}">${i+1}</a></li> 
    <c:set var="maxPage" value="${i+1}"></c:set>
    </c:forEach>
    
    
    <li class="page-item"><a class="page-link" href="/ReupTrailerMovie/Home/page?numPage=${CurrentPage<maxPage?CurrentPage+1:maxPage}">Next</a></li>
  </ul>
</nav>

			</div>
	
	</div>
	
</div>
<%--top view --%>
<div class="d-none d-md-block col-3">

<h2 class="text-white">Top View</h2>

<c:forEach var="item" items="${listTopVideo}">

<div class="my-2">
<jsp:include page="./Movie/TopMovie.jsp">
			<jsp:param value="${item.title}" name="title"/>
			<jsp:param value="${item.poster}" name="poster"/>
			<jsp:param value="${item.views}" name="views"/>

</jsp:include>
</div>

</c:forEach>



</div>

</div>

<%--footer --%>

<%@include  file="/views/footer/Footer.jsp"%> 
</body>
</html>