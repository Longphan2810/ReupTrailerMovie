<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="card m-1" style="width: 100% ;height :330px; background-color: #000217">

	<div class=" movieTong my-3" style="position:relative;  height: 250px">
		<div style="position: absolute; width: 100%" > 
		 <img src="/ReupTrailerMovie/imgPoster/${param.poster}" style="width: 100%; height: 250px" class="card-img-top" alt="...">
		</div>
		
		<div style="position: absolute; " class="nenChe">
		
		<div class="w-100  h-100 text-center">
		
				<div class="h-25 ">
				</div>
				<a href="/ReupTrailerMovie/ActionVideoServlet/playvideo?idVideo=${param.idVideo}" class="my-auto textTaga">
				<svg xmlns="http://www.w3.org/2000/svg" width="70" height="70" fill="currentColor" class="bi bi-play-fill" viewBox="0 0 16 16">
  				<path d="m11.596 8.697-6.363 3.692c-.54.313-1.233-.066-1.233-.697V4.308c0-.63.692-1.01 1.233-.696l6.363 3.692a.802.802 0 0 1 0 1.393"/>
				</svg>
				 Play	
				</a>
				<div class="h-25 ">
				</div>
				
				<div class="row">
				<div class="col-6">
				<a href="${param.url}${param.idVideo}" class="my-auto textTaga"> 
				<svg xmlns="http://www.w3.org/2000/svg" style="color: ${param.like==true?'red':''}" width="30" height="30" fill="currentColor" class="bi bi-heart-fill" viewBox="0 0 16 16">
  				<path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314"/>
				</svg>
				
				Like	</a> 
				</div>
				
				
				<div class="col-6">
				<a  class="my-auto textTaga" data-bs-toggle="modal" data-bs-target="#exampleModal${param.idVideo}">
				
				<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-share" viewBox="0 0 16 16">
  				<path d="M13.5 1a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3M11 2.5a2.5 2.5 0 1 1 .603 1.628l-6.718 3.12a2.5 2.5 0 0 1 0 1.504l6.718 3.12a2.5 2.5 0 1 1-.488.876l-6.718-3.12a2.5 2.5 0 1 1 0-3.256l6.718-3.12A2.5 2.5 0 0 1 11 2.5m-8.5 4a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3m11 5.5a1.5 1.5 0 1 0 0 3 1.5 1.5 0 0 0 0-3"/>
				</svg>
				
				 Share	</a> 
				</div>
				</div>
				
		</div>
		
		
		</div>
	</div>
	
 <h5 class="card-title text-white ">${param.title} </h5>
</div>
    
    


<!-- Modal -->
<form action="/ReupTrailerMovie/ShareVideo" method="post">
<div class="modal fade" id="exampleModal${param.idVideo}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
        <button type="submit" formaction="/ReupTrailerMovie/ShareVideo/home?idVideo=${param.idVideo}" class="btn btn-primary">Chia sẻ</button>
      </div>
    </div>
  </div>
</div>
    </form>
    
