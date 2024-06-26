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

.invalidInput:{
border: 1px solid red  ;

}

/* Thay đổi màu viền khi input được focus */
input[type="text"]:focus {
    border-color: #007bff  ;
}

input[type="text"]:after {
    border-color: #007bff  ;
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
<div  class="col-6 " style="height: 100%">
<div role="tabpanel">
  <!-- List group -->
  <div class="list-group " id="myList" role="tablist">
   
   <div class="row">
    <div class="col-6">
     <a class="${currentAction!='Register'?'active':'' }  list-group-item-action  list-group-item  text-white"  style="text-decoration: none; background-color: #0D1023 !important" data-bs-toggle="list" href="#home" role="tab"><h3>Login</h3> </a>
    </div>
    <div class="col-6">
    <a class=" ${currentAction=='Register'?'active':'' } list-group-item-action list-group-item  text-white" style="text-decoration: none;  background-color: #0D1023 !important" data-bs-toggle="list" href="#profile" role="tab"> <h3>Register</h3> </a>
   </div>
   </div>

  </div>

  <!-- Tab panes -->
  <div class="tab-content">
  
   <%-- Login form   --%>
    <div class="tab-pane ${currentAction!='Register'?'active':'' } text-white" id="home" role="tabpanel">
    
    	<div class="container">
    	
    	<h2 class="my-4">Welcome !</h2>
    	
    	<form action="/ReupTrailerMovie/Login" method="post">
    	
    	
    	<div class="form-floating mb-3" >
  			<input type="email" class="form-control text-white" value="${emailOut==null?CookieUser:emailOut}" name="mail" required="required" id="floatingInput" style="background-color: #0D1023 !important" placeholder="name@example.com">
 			<label  for="floatingInput">Email address</label>
 					 <%--alert  --%>
   <div id="liveAlertPlaceholder" >	
   <div class="${saiMail==true?'':'d-none'}">
   	<div class="alert alert-danger alert-dismissible" role="alert">   
   <div>Email này không tồn tại trong hệ thống !</div>   
   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
   </div></div></div>
    <%--alert  --%>
		</div>
		
		<div class="form-floating">
  			<input type="password" class="form-control text-white" value="${passOut==null?CookiePass:passOut}" name="pass" required="required" style="background-color: #0D1023 !important" id="floatingPassword" placeholder="Password">
  			<label for="floatingPassword">Password</label>
  					 <%--alert  --%>
   <div id="liveAlertPlaceholder" >	
   <div class="${saiPass==true?'':'d-none'}">
   	<div class="alert alert-danger alert-dismissible" role="alert">   
   <div> ${ban==true?'Tài khoản đã bị khoá':'Sai Mật khẩu Hoặc tài khoản chưa được kích hoạt'} !</div>   
   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
   </div></div></div>
    <%--alert  --%>
   
		</div>
    	
		<div class=" my-1 row">
			<div class="col-8">
		
  			<input type="checkbox" value="true" name ="remember">
  			<label style="background-color: #0D1023 !important" >Remember me</label>
  			</div>
  			<div class="col-4 ">
  			<a href="/ReupTrailerMovie/views/ForgotPass.jsp">
  				<label style="background-color: #0D1023 !important" >Forgot Password</label>
  			</a>
  			</div>
		</div>
    	<div class="text-center">
    	<button type="submit" class="btn btn-warning btn-lg">Login</button>
    	</div>
    	</form>
    	
    	</div>
    
    
    
    
    
    
    </div>
    
    
    <%-- Register form  --%>
    
    
    
    <div class="tab-pane text-white ${currentAction=='Register'?'active':'' }" id="profile" role="tabpanel">
    
    <%--alert  --%>
   <div id="liveAlertPlaceholder" >
   <div class="${okMail==true?'':'d-none'}" >
   	<div class="alert alert-success alert-dismissible" role="alert">   
   <div>Đã gửi mail xác nhận về email, Vui lòng kiểm tra mail !</div>   
   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
   </div></div></div>
    <%--alert  --%>
    
    	<div class="container mt-4">
    	
    	<form action="/ReupTrailerMovie/Register" method="post">
    	
    	<div class="form-floating mb-3" >
  			<input type="text" class="form-control text-white" value="${user.fullname}" name="fullname" required="required"  id="floatingInput" style="background-color: #0D1023 !important" placeholder="Fullname">
 			<label  for="floatingInput">Full Name</label>
 			 <%--alert  --%>
   <div id="liveAlertPlaceholder" >	
   <div class="${validName==true?'':'d-none'}">
   	<div class="alert alert-danger alert-dismissible" role="alert">   
   <div>Tên Không Hợp Lệ !</div>   
   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
   </div></div></div>
    <%--alert  --%>
		</div>
    	
    	<div class="form-floating mb-3" >
  			<input type="email" class="form-control text-white" value="${user.emailUser}" name="emailUser" required="required" id="floatingInput" style="background-color: #0D1023 !important" placeholder="name@example.com">
 			<label  for="floatingInput">Email address</label>
 			 <%--alert  --%>
   <div id="liveAlertPlaceholder" >	
   <div class="${trungMail==true?'':'d-none'}">
   	<div class="alert alert-danger alert-dismissible" role="alert">   
   <div>Email này đã được đăng ký trong hệ thống !</div>   
   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
   </div></div></div>
    <%--alert  --%>
 			
		</div>
			
		
		
		<div class="form-floating mb-3">
  			<input type="password" class="form-control text-white" name="password" value="${user.password}" required="required" style="background-color: #0D1023 !important" id="floatingPassword" placeholder="Password">
  			<label for="floatingPassword">Password</label>
  					 <%--alert  --%>
   <div id="liveAlertPlaceholder" >
   <div class="${shortPass==true?'':'d-none'}">
   	<div class="alert alert-danger alert-dismissible" role="alert">   
   <div>Mật khẩu vui lòng lớn hơn 8 ký tự!</div>   
   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
   </div></div></div>
    <%--alert  --%>
		</div>
    	
		<div class="form-floating mb-3">
  			<input type="password" class="form-control text-white invalidInput" value="${passConfirm}"  name="passwordConfirm" required="required" style="background-color: #0D1023 !important" id="floatingPassword" placeholder="Password">
  			<label for="floatingPassword">Confirm Password</label>
  		 <%--alert  --%>
   <div id="liveAlertPlaceholder" >
   <div class="${difPass==true?'':'d-none'}">
   	<div class="alert alert-danger alert-dismissible" role="alert">   
   <div>Mật khẩu không khớp!</div>   
   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
   </div></div></div>
    <%--alert  --%>
		</div>
			
		
    	<div class="text-center">
    	<button type="submit" class="btn btn-warning btn-lg">Sign Up</button>
    	
    	
    	</div>
    	
    	<input type="hidden" name="admin" value="false" >
    	<input type="hidden" name="admin" value="false" >
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