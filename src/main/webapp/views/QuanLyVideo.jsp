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
    
    	<div class="container">
    		<div class="container">
    			
    		<form action="">
    	<%-- info movie --%>
    	<div class="row" >
    	<%-- img  --%>
    	<div class="col-4">
    		<img alt="" src="/ReupTrailerMovie/imgAsmJava/dochanh.png" style="width: 80%;height: 250px">
    	</div>
    	<%-- info movie  --%>
    	<div class="col-8">
    	
    		<div class="form-floating mb-3"">
  			<input type="text" class="form-control text-white" style="background-color: #0D1023 !important" id="floatingPassword" placeholder="Youtbe ID">
  			<label for="floatingPassword">Youtbe ID</label>
		</div>
		
		<div class="form-floating mb-3"">
  			<input type="text" class="form-control text-white" style="background-color: #0D1023 !important" id="floatingPassword" placeholder="Video Title">
  			<label for="floatingPassword">Video Title</label>
		</div>
		
		<div class="form-floating mb-3"">
  			<input type="text" class="form-control text-white" style="background-color: #0D1023 !important" id="floatingPassword" placeholder="Views">
  			<label for="floatingPassword">Views</label>
		</div>
    	
    	<div class="row">
    	
    	<div class="col-6">
    		<input type="radio" name="active" value="true" >
    		<label for="floatingPassword">Active</label>
    	</div>
    	<div class="col-6" >
    		<input type="radio" name="active" value="false">
    		<label for="floatingPassword">Inactive</label>
    	</div>
    	
    	</div>
    	
    	
    	</div>
    	
    	</div>
    		<%-- description --%>
    	<div class="row">
    	<div class="mb-3">
  		<label for="exampleFormControlTextarea1" class="form-label">Example textarea</label>
  		<textarea class="form-control text-white" id="exampleFormControlTextarea1" style="background-color: #0D1023 !important" rows="5"></textarea>
		</div>
    	
    	</div>
    	
    	<%-- button  --%>
    	
    	<div class="row">
    	
    	<div class="col-3 ">
    	<button type="button" class="btn btn-secondary w-100">Create</button>
    	</div>
    	<div class="col-3">
    	<button type="button" class="btn btn-secondary w-100">Update</button>
    	</div>
    	<div class="col-3">
    	<button type="button" class="btn btn-secondary w-100">Delete</button>
    	</div>
    	<div class="col-3">
    	<button type="button" class="btn btn-secondary w-100">Reset</button>
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
    <tr>
      <th >1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
      <td>  <a  href="#"> Edit</a> </td>
    </tr>
    <tr>
      <th >1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
        <td>  <a  href="#"> Edit</a> </td>
    </tr>
    <tr>
      <th >1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
          <td>  <a  href="#"> Edit</a> </td>
    </tr>
     <tr>
      <th >1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
          <td>  <a  href="#"> Edit</a> </td>
    </tr>
     <tr>
      <th >1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
          <td>  <a  href="#"> Edit</a> </td>
    </tr>
     <tr>
      <th >1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
          <td>  <a  href="#"> Edit</a> </td>
    </tr>
     <tr>
      <th >1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
          <td>  <a  href="#"> Edit</a> </td>
    </tr>
     <tr>
      <th >1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
          <td>  <a  href="#"> Edit</a> </td>
    </tr>
     <tr>
      <th >1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
          <td>  <a  href="#"> Edit</a> </td>
    </tr>
    <tr>
      <th >1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
          <td>  <a  href="#"> Edit</a> </td>
    </tr>
    <tr>
      <th >1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
          <td>  <a  href="#"> Edit</a> </td>
    </tr>
    <tr>
      <th >1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
          <td>  <a  href="#"> Edit</a> </td>
    </tr>
     <tr>
      <th >1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
          <td>  <a  href="#"> Edit</a> </td>
    </tr>
    <tr>
      <th >1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
         <td>  <a  href="#"> Edit</a> </td>
    </tr>
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

 var

</script>

</body>
</html>