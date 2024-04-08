
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-lg " style="background-color: #000217">
  <div class="container-fluid bg-color-1 w-50" >
    <a class="navbar-brand text-warning " href="/ReupTrailerMovie/views/Home.jsp">  <h4>NekoMovie</h4> </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
   
  </div>
   <div class="collapse navbar-collapse mx-auto w-25 " id="navbarNav">
      <ul class="navbar-nav mx-auto">
        <li class="nav-item me-3">
          <a class="nav-link  text-white h4"  href="/ReupTrailerMovie/views/Home.jsp">  <h4>Home</h4>  </a>
        </li>
        
        <c:if test="${sessionScope.user!=null}">
        <li class="nav-item me-3">
          <a class="nav-link text-white " href="/ReupTrailerMovie/FavoriteVideo/favorite"> <h4>My Favorite</h4> </a>
        </li>
        </c:if>
        
        <c:if test="${sessionScope.user.admin}">
        <li class="nav-item me-3">
          <a class="nav-link text-white " href="/ReupTrailerMovie/VideoManagerServlet/RestVideoForm"> <h4>Video</h4> </a>
        </li>
         </c:if>
        
         <c:if test="${sessionScope.user.admin}">
       <li class="nav-item me-3">
          <a class="nav-link text-white " href="/ReupTrailerMovie/UserManagerServlet/reset"> <h4>User</h4> </a>
        </li>
        	</c:if>
        
        
         <c:if test="${sessionScope.user.admin}">
         <li class="nav-item me-3">
          <a class="nav-link text-white " href="/ReupTrailerMovie/ReportServlet"> <h4>Reports</h4> </a>
        </li>
        </c:if>
        
       
        <li class="nav-item dropdown me-3">
          <a class="nav-link  text-white " href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            <h4>Account</h4>
          </a>
          <ul class="dropdown-menu">
          
          <c:if test="${sessionScope.user==null}">
            <li><a class="dropdown-item" href="/ReupTrailerMovie/Login">Login / Register</a></li>
          </c:if> 
           
 		 <c:if test="${sessionScope.user!=null}">
 		 <li><a class="dropdown-item" href="/ReupTrailerMovie/UserChanges/ChangesPass">Changes Password</a></li>
            <li><a class="dropdown-item" href="/ReupTrailerMovie/UserChanges/EditProfile">Edit profile</a></li>
            <li><a class="dropdown-item" href="/ReupTrailerMovie/logout">Log out</a></li>
          </c:if> 
           
           
          </ul>
        </li>
        
      </ul>
    </div>
</nav>



