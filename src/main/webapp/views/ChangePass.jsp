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
   
   <div class="row">
    <div class="col-10">
     <a class="active  list-group-item-action  list-group-item  text-white"  style="text-decoration: none; background-color: #0D1023 !important" data-bs-toggle="list" href="#home" role="tab">
     		<h3>Change your password</h3> </a>
    </div>

   </div>

  </div>

  <!-- Tab panes -->
  <div class="tab-content">
  
  
    <div class="tab-pane active text-white" id="home" role="tabpanel">
    
    	<div class="container">
    	
    	
    	<form action="/ReupTrailerMovie/UserChanges/ChangesPass" method="post">
    	<%--alert  --%>
   <div id="liveAlertPlaceholder" >
   <div class="${okUpdate==true?'':'d-none'}" >
   	<div class="alert alert-success alert-dismissible" role="alert">   
   <div>Cập nhật thành công !</div>   
   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
   </div></div></div>
    <%--alert  --%>
    	
    	<div class="form-floating mb-3">
  			<input type="password" class="form-control text-white" required="required" name="pass" style="background-color: #0D1023 !important" id="floatingPassword" placeholder="Password">
  			<label for="floatingPassword">Password</label>
  				<%--alert  --%>
   <div id="liveAlertPlaceholder" >	
   <div class="${FailPass==true?'':'d-none'}">
   	<div class="alert alert-danger alert-dismissible" role="alert">   
   <div>Vui lòng nhập đúng mật khẩu của tài khoản hiện tại !</div>   
   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
   </div></div></div>
    <%--alert  --%>
		</div>
		
		<div class="form-floating mb-3">
  			<input type="password" class="form-control text-white" required="required" name="newPass" style="background-color: #0D1023 !important" id="floatingPassword" placeholder="Password">
  			<label for="floatingPassword">New Password</label>
  			
  			<%--alert  --%>
   <div id="liveAlertPlaceholder" >	
   <div class="${ShortPass==true?'':'d-none'}">
   	<div class="alert alert-danger alert-dismissible" role="alert">   
   <div>Mật khẩu vui lòng dài hơn 7 ký tự !</div>   
   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
   </div></div></div>
    <%--alert  --%>
		</div>
    	
		<div class="form-floating mb-3">
  			<input type="password" class="form-control text-white" required="required" name="confirmPass" style="background-color: #0D1023 !important" id="floatingPassword" placeholder="Password">
  			<label for="floatingPassword">Confirm Password</label>
  			
  			
  			<%--alert  --%>
   <div id="liveAlertPlaceholder" >	
   <div class="${DiffPass==true?'':'d-none'}">
   	<div class="alert alert-danger alert-dismissible" role="alert">   
   <div>Mật khẩu Không khớp !</div>   
   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
   </div></div></div>
    <%--alert  --%>
  			
		</div>
	
	
		<div class=" my-1 row">
			<div class="col-8">
		
  			
  			</div>
  			
  			<div class="col-4 ">
  			<a href="#">
  				<label style="background-color: #0D1023 !important" >Send code again</label>
  			</a>
  			</div>
		</div>

    	<div class="text-center my-3">
    	<button type="submit" class="btn btn-warning btn-lg">Confirm</button>
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

 

</script>

</body>
</html>