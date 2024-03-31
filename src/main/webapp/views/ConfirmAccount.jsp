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
<%@ include file="/views/navbar/NavBarUser.jsp" %>
</div>



<div class="shadow-lg row container h-100 w-100 mx-auto p-4 my-5" style="background-color: #0D1023">
<%------------ form  ----------------------- --%>
<div  class="col-6 " style="height: 500px">
<div role="tabpanel">
  <!-- List group -->
  <div class="list-group my-5 " id="myList" role="tablist">
   
   <div class="row my-4">
    <div class="col-10">
     <a class="active  list-group-item-action  list-group-item  text-white"  style="text-decoration: none; background-color: #0D1023 !important" data-bs-toggle="list" href="#home" role="tab">
     		<h3>${thanhCong}</h3> </a>
    </div>

   </div>

  </div>

  <!-- Tab panes -->
  <div class="tab-content">
  
  
    <div class="tab-pane active text-white" id="home" role="tabpanel">
    
    	<div class="container">
    	
    	
    	<form action="">
    	
    	
    	<h4> Vui lòng Quay lại trang đăng nhập để sử dụng ứng dụng !</h4>
		
    	<div class="text-center my-3">
    	
    	<button type="submit" formaction="/ReupTrailerMovie/views/Login&Register.jsp" class="btn btn-warning btn-lg">Log in</button>
    	
    	</div>
    	</form>
    	
    	</div>
    
    
    
    
    
    
    </div>
    
    
    
    
    
    
  
  </div>
</div>
	

</div>
<%------------ Img   ----------------------- --%>

<div class="col-6">
<img alt="" src="/ReupTrailerMovie/imgAsmJava/gorila.png" class="w-100 h-100">
</div>
</div>





<%--footer --%>

<%@include  file="/views/footer/Footer.jsp"%> 

<script type="text/javascript">

 var

</script>

</body>
</html>