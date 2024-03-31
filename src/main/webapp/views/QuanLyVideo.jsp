<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
 <style type="text/css">
<%@ include file="/views/CssStyle/Style1.css" %>

.list-group-item-action{
border: none;

}
.list-group .active{
border-bottom: 2px solid #EB8A05 !important ;

}

</style>


</head>
<body >

<%--Nav bar --%>
<div class="mb-3 shadow-lg">
<%@ include file="/views/navbar/NavBarAdmin.jsp" %>
</div>



<div class="shadow-lg row container h-100 w-100 mx-auto p-4 my-5" style="background-color: #0D1023">
<%------------ form  ----------------------- --%>
<div  class="col-12 " style="height: 100%">
<div role="tabpanel">
  <!-- List group -->
  <div class="list-group " id="myList" role="tablist">
   
   <div class="row">
    <div class="col-6">
     <a class="active  list-group-item-action  list-group-item  text-white"  style="text-decoration: none; background-color: #0D1023 !important" data-bs-toggle="list" href="#home" role="tab"><h3>Video Edition</h3> </a>
    </div>
    <div class="col-6">
    <a class=" list-group-item-action list-group-item  text-white" style="text-decoration: none;  background-color: #0D1023 !important" data-bs-toggle="list" href="#profile" role="tab"> <h3>Video List</h3> </a>
   </div>
   </div>

  </div>

  <!-- Tab panes -->
  <div class="tab-content my-3">
  
  <%-- Quan ly video --%>
    <div class="tab-pane active text-white " id="home" role="tabpanel">
    				 <%--alert  --%>
   <div id="liveAlertPlaceholder" >	
   <div class="${capNhat==true?'':'d-none'}">
   	<div class="alert alert-success alert-dismissible" role="alert">   
   <div>Thanh Cong !</div>   
   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
   </div></div></div>
    <%--alert  --%>
    	<div class="container">
    		<div class="container">
    			
   <form action="/ReupTrailerMovie/VideoManagerServlet" method="post" enctype="multipart/form-data">
    	<%-- info movie --%>
    	
    	<div class="row" >
    	<%-- img  --%>
    	<div class="col-4">
    		<img alt="" src="/ReupTrailerMovie/imgPoster/${video.poster}" id="previewImage"  style="width: 80%;height: 250px">
    		<div class="mb-3">
    		  <label for="formFile" class="form-label">Poster</label>
  				<input class="form-control"  name="poster" type="file" id="fileInput">
			</div>
    	</div>
    	<%-- info movie  --%>
    	<div class="col-8">
    	
    		<div class="form-floating mb-3">
  			<input type="text" class="form-control text-white" required="required" value="${video.idVideo}" name="idVideo" style="background-color: #0D1023 !important" id="floatingPassword" placeholder="Youtbe ID">
  			<label for="floatingPassword">Youtube ID</label>
  					 <%--alert  --%>
   <div id="liveAlertPlaceholder" >	
   <div class="${trungId==true?'':'d-none'}">
   	<div class="alert alert-danger alert-dismissible" role="alert">   
   <div>Video có id này đã tồn tại trong hệ thống !</div>   
   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
   </div></div></div>
    <%--alert  --%>
    				 <%--alert  --%>
   <div id="liveAlertPlaceholder" >	
   <div class="${KhongCoID==true?'':'d-none'}">
   	<div class="alert alert-danger alert-dismissible" role="alert">   
   <div>Không tìm thấy id video để thao tác !</div>   
   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
   </div></div></div>
    <%--alert  --%>
		</div>
		
		<div class="form-floating mb-3">
  			<input type="text" class="form-control text-white" required="required" value="${video.title}" name="title" style="background-color: #0D1023 !important" id="floatingPassword" placeholder="Video Title">
  			<label for="floatingPassword">Video Title</label>
		</div>
		
		<div class="form-floating mb-3">
  			<input type="number" class="form-control text-white" required="required" value="${video.views}" name="views" style="background-color: #0D1023 !important" id="floatingPassword" placeholder="Views">
  			<label for="floatingPassword">Views</label>
		</div>
    	
    	<div class="row">
    	
    	<div class="col-6">
    		<input type="radio" ${video.active==true?'checked':''} required="required" name="active" value="true" >
    		<label for="floatingPassword">Active</label>
    	</div>
    	<div class="col-6" >
    		<input type="radio" ${video.active==true?'':'checked'} name="active" value="false">
    		<label for="floatingPassword">Inactive</label>
    	</div>
    	
    	</div>
    	
    	
    	</div>
    	
    	</div>
    		<%-- description --%>
    	<div class="row">
    	<div class="mb-3">
  		<label for="exampleFormControlTextarea1" class="form-label">Example textarea</label>
  		<textarea class="form-control text-white" value="${video.description}"  name="description" id="exampleFormControlTextarea1" style="background-color: #0D1023 !important" rows="5"></textarea>
		</div>
    	
    	</div>
    	
    	<%-- button  --%>
    	
    	<div class="row">
    	
    	<div class="col-3 ">
    	<button type="submit" formaction="/ReupTrailerMovie/createVideo" class="btn btn-secondary w-100">Create</button>
    	</div>
    	<div class="col-3">
    	<button type="submit" formaction="/ReupTrailerMovie/updateVideo" class="btn btn-secondary w-100">Update</button>
    	</div>
    	<div class="col-3">
    	<button type="submit" formaction="/ReupTrailerMovie/DeleteVideo" class="btn btn-secondary w-100">Delete</button>
    	</div>
    	<div class="col-3">
    	<button type="submit" formaction="/ReupTrailerMovie/RestVideoForm" class="btn btn-secondary w-100">Reset</button>
    	</div>
    	
    	</div>
    	
    	</form>
    	
    		
    		</div>
    	
    	</div>
    
    
    
    
    
    
    </div>
    
    
    
    
      
  <%-- List video --%>
    
    <div class="tab-pane text-white" id="profile" role="tabpanel">
    
    	<div class="container mt-4 table-responsive " style="height: 500px">
    	
    <table class="table" style="background-color: #0D1023 !important">
  <thead>
    <tr>
      <th scope="col">Id Video</th>
      <th scope="col">Title Video</th>
      <th scope="col">Views Count</th>
      <th scope="col">Status</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
  
  	<c:forEach var="item" items="${listVideo}">
  	 <tr>
      <th >${item.idVideo}</th>
      <td>${item.title}</td>
      <td>${item.views}</td>
      <td>${item.active}</td>
      <td>  <a  href="/ReupTrailerMovie/EditVideo?idVideo=${item.idVideo}"> Edit</a> </td>
    </tr>
  	
  	</c:forEach>
  

  </tbody>
</table>
    	
    	</div>
    
    </div>

  </div>
</div>
	

</div>
</div>





<%--footer --%>

<%@include  file="/views/footer/Footer.jsp"%> 

<script type="text/javascript">

// Lắng nghe sự kiện khi người dùng chọn tệp tin
document.getElementById('fileInput').addEventListener('change', function(event) {
    var file = event.target.files[0];
    var reader = new FileReader();
    
    // Đọc nội dung của tệp tin được chọn
    reader.onload = function(event) {
        var previewImage = document.getElementById('previewImage');
        
        // Cập nhật thuộc tính src của thẻ img để hiển thị hình ảnh đã chọn
        previewImage.src = event.target.result;
    };
    
    reader.readAsDataURL(file);
});

</script>

</body>
</html>