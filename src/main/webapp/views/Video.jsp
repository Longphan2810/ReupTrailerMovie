<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions"	 prefix="fn" %>
    
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

<%--Nav bar --%>
<div class="mb-3 shadow-lg">
<%@ include file="/views/navbar/NavBarUser.jsp" %>
</div>

 <div class="mx-auto d-flex justify-content-center" style="width: 100% ;height: 500px"> 
 <iframe width=80%; height="100%" src="https://www.youtube.com/embed/${videoCurrent.idVideo}"></iframe>
 
 </div>
 
<%-- description Video --%>

<div>
 <%-- title and like share --%>
<div class="w-100  py-3 text-white container " >
	<div class="row">
	<div class="col-md-9">
	<h4 class="text-white">${videoCurrent.title}</h4>
	</div>
	
	<div class="col-md-3 mx-auto text-center">
	<form action="">
	<button type="submit" formmethod="post" formaction="/ReupTrailerMovie/FavoriteVideo/video?likeVideo=${videoCurrent.idVideo}" class="btn btn-secondary">
	

		<c:forEach var="favorite" items="${listMyFavorite}">
			<c:if test="${favorite.video.idVideo==videoCurrent.idVideo}">
			<c:set var="like" value="true" ></c:set>
			</c:if>
		
		</c:forEach>

	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" style="color: ${like==true?'red':''}" fill="currentColor" class="bi bi-heart-fill" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314"/>
</svg> Like
	</button>
	<button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#exampleModalvideo${videoCurrent.idVideo}">
	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-share" viewBox="0 0 16 16">
  <path d="M13.5 1a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3M11 2.5a2.5 2.5 0 1 1 .603 1.628l-6.718 3.12a2.5 2.5 0 0 1 0 1.504l6.718 3.12a2.5 2.5 0 1 1-.488.876l-6.718-3.12a2.5 2.5 0 1 1 0-3.256l6.718-3.12A2.5 2.5 0 0 1 11 2.5m-8.5 4a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3m11 5.5a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3"/>
</svg> Share
	</button>
	</form>
	
	



<%--footer --%>
	
	</div>
	</div>

</div>
 <%-- views  and description --%>

	<div class="w-100 h-100 py-5 text-white container " style="background-color: #0D1023;" >
		<h5 class="ms-5"> ${videoCurrent.views} Views </h5>
		<h4 class="ms-5"> 
		${videoCurrent.description}
		</h4>
	
	
	</div>




</div>
 




<%-- container movie render and top view movie --%>

<div class="row bodyContent h-100" >

<%--Movie render --%>
<div >
<h4 class="ms-3 text-white">Gan Day </h4>

	
	<c:if test="${fn:length(listVuaXem)-1>=0}">
	
	<div  class="row mx-auto">
	<c:forEach var="i"  begin="0" end="${fn:length(listVuaXem)<4?fn:length(listVuaXem)-1:3}" step="1">
		<div class="col-sm-6 col-md-4 col-lg-3  col-sx-12 ">
		
		<jsp:include page="./Movie/MovieRender.jsp">
			<jsp:param value="${listVuaXem[i].title}" name="title"/>
			<jsp:param value="${listVuaXem[i].poster}" name="poster"/>
			<jsp:param value="${listVuaXem[i].idVideo}" name="idVideo"/>
		</jsp:include>
		
		</div>
		</c:forEach>
	</div>
	
	</c:if>


</div>


</div>

<!-- Modal -->
<form action="/ReupTrailerMovie/ShareVideo" method="post">
<div class="modal fade" id="exampleModalvideo${videoCurrent.idVideo}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        
        
        	<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Send Video to Email </label>
  <input type="email" name="toEmail" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
</div>
        
      </div>
      <div class="modal-footer">
      
     
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="submit" formaction="/ReupTrailerMovie/ShareVideo/video?idVideo=${videoCurrent.idVideo}" class="btn btn-primary">Chia sẻ</button>
        
      </div>
    </div>
  </div>
</div>
    </form>



<%@include  file="/views/footer/Footer.jsp"%> 
</body>
</html>