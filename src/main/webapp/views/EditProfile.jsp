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
<div  class="col-12 " style="height: 100%">
<div role="tabpanel">
  <!-- List group -->
  <div class="list-group my-5 " id="myList" role="tablist">
   
   <div class="row">
    <div class="col-6">
     <a class="active  list-group-item-action  list-group-item  text-white"  style="text-decoration: none; background-color: #0D1023 !important" data-bs-toggle="list" href="#home" role="tab">
     		<h3>Edit  Your Profile</h3> </a>
    </div>

   </div>

  </div>

  <!-- Tab panes -->
  <div class="tab-content row">
  
  	<div class="col-2">
  	</div>
    <div class="tab-pane active text-center text-white col-8" id="home" role="tabpanel">
    
    	<div class="container">
    	
    	 <%--alert  --%>
   <div id="liveAlertPlaceholder" >
   <div class="${okUpdate==true?'':'d-none'}" >
   	<div class="alert alert-success alert-dismissible" role="alert">   
   <div>Cập nhật thành công !</div>   
   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
   </div></div></div>
    <%--alert  --%>
    	<form action="/ReupTrailerMovie/UserChanges/EditProfile" method="post">
    	
    	<div class="form-floating mb-3" >
  			<input type="email" class="form-control text-white" value="${sessionScope.user.emailUser}" readonly="readonly" name="emailUser" id="floatingInput" style="background-color: #0D1023 !important" placeholder="name@example.com">
 			<label  for="floatingInput">Email address</label>
		</div>
    	
    	<div class="form-floating mb-3">
  			<input type="text" class="form-control text-white" required="required" value="${sessionScope.user.fullname}" name="fullname" style="background-color: #0D1023 !important" id="floatingPassword" placeholder="Password">
  			<label for="floatingPassword">Name</label>
  			
  			<%--alert  --%>
   <div id="liveAlertPlaceholder" >	
   <div class="${validName==true?'':'d-none'}">
   	<div class="alert alert-danger alert-dismissible" role="alert">   
   <div>Tên Không Hợp Lệ !</div>   
   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
   </div></div></div>
    <%--alert  --%>
  			
		</div>
		
		<div class="form-floating mb-3">
  			<input type="text" class="form-control text-white" value="${sessionScope.user.address}" name="address" style="background-color: #0D1023 !important" id="floatingPassword" placeholder="Password">
  			<label for="floatingPassword">Address</label>
		</div>
		<div class="form-floating mb-3">
  			<input type="text" class="form-control text-white"  value="${sessionScope.user.phone}" name="phone" style="background-color: #0D1023 !important" id="floatingPassword" placeholder="Password">
  			<label for="floatingPassword">Phone number</label>
  			<%--alert  --%>
   <div id="liveAlertPlaceholder" >	
   <div class="${PhoneValid==true?'':'d-none'}">
   	<div class="alert alert-danger alert-dismissible" role="alert">   
   <div>SĐT chỉ nhập số và từ 10 hoặc 11 số !</div>   
   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
   </div></div></div>
    <%--alert  --%>
  			
		</div>
		
    	
    	<div class="form-floating mb-3">
  			<input type="password" class="form-control text-white" name="password" style="background-color: #0D1023 !important" id="floatingPassword" placeholder="Password">
  			<label for="floatingPassword">Password</label>
  			
  			<%--alert  --%>
   <div id="liveAlertPlaceholder" >	
   <div class="${PassFail==true?'':'d-none'}">
   	<div class="alert alert-danger alert-dismissible" role="alert">   
   <div>Vui lòng nhập đúng mật khẩu của tài khoản hiện tại !</div>   
   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
   </div></div></div>
    <%--alert  --%>
  			
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

</div>





<%--footer --%>

<%@include  file="/views/footer/Footer.jsp"%> 

<script type="text/javascript">

 var

</script>

</body>
</html>