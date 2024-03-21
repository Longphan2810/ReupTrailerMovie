<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="col-3 ">
<button type="button" class="btn btn-lg w-100 active btn-outline-warning">Movie</button>
</div>
<div class="col-3">
<button type="button" class="btn btn-lg w-100 btn-outline-warning">Drama</button>
</div>

<div class="col-3">
<button type="button" class="btn btn-lg  w-100 btn-outline-warning">Music</button>
</div>
<div class="col-3">
<button type="button" class="btn btn-lg w-100 btn-outline-warning">More</button>
</div>
</div>

<%-- container movie render and top view movie --%>

<div class="row bodyContent h-100" >

<%--Movie render --%>
<div class="col-9 ">
<h4 class="ms-3 text-white">Movie</h4>
	<div  class="row mx-auto">
		<div class="col-sm-6 col-md-4 col-lg-3  col-sx-12 ">
		<%@include file="/views/Movie/MovieRender.jsp" %>
		</div>
		<div class="col-sm-6 col-md-4  col-lg-3  col-sx-12 ">
		<%@include file="/views/Movie/MovieRender.jsp" %>
		</div>
		<div class="col-sm-6 col-md-4  col-lg-3  col-sx-12 ">
		<%@include file="/views/Movie/MovieRender.jsp" %>
		</div>
		<div class="col-sm-6 col-md-4 col-lg-3  col-sx-12 ">
		<%@include file="/views/Movie/MovieRender.jsp" %>
		</div>
		<div class="col-sm-6 col-md-4 col-lg-3  col-sx-12 ">
		<%@include file="/views/Movie/MovieRender.jsp" %>
		</div>
		<div class="col-sm-6 col-md-4  col-lg-3  col-sx-12 ">
		<%@include file="/views/Movie/MovieRender.jsp" %>
		</div>
		<div class="col-sm-6 col-md-4  col-lg-3  col-sx-12 ">
		<%@include file="/views/Movie/MovieRender.jsp" %>
		</div>
		<div class="col-sm-6 col-md-4 col-lg-3  col-sx-12 ">
		<%@include file="/views/Movie/MovieRender.jsp" %>
		</div>
			
	
	</div>
	

</div>
<%--top view --%>
<div class="d-none d-md-block col-3">

<h2 class="text-white">Top View</h2>

<div class="my-2">
<%@include file="/views/Movie/TopMovie.jsp" %>

</div>


<div class="my-2">
<%@include file="/views/Movie/TopMovie.jsp" %>

</div>
<div class="my-2">
<%@include file="/views/Movie/TopMovie.jsp" %>

</div>
<div class="my-2">
<%@include file="/views/Movie/TopMovie.jsp" %>

</div>


</div>

</div>

<%--footer --%>

<%@include  file="/views/footer/Footer.jsp"%> 
</body>
</html>