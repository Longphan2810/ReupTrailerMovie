package neko.com.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neko.com.dao.ShareDAO;
import neko.com.dao.VideoDAO;
import neko.com.model.Share;
import neko.com.model.Users;
import neko.com.model.Video;
import neko.com.ulti.MailHelper;

/**
 * Servlet implementation class ShareVideoServlet
 */
@WebServlet({"/ShareVideo/home","/ShareVideo/video"})
public class ShareVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShareDAO shareDao = new ShareDAO();
	private VideoDAO videoDao = new VideoDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareVideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uri = request.getRequestURI();
		
		if(request.getMethod().equalsIgnoreCase("post")) {
			
			
			getShareVideo(request, response);
			
			if(uri.contains("/ShareVideo/video")) {
				
				request.getRequestDispatcher("/views/Video.jsp").forward(request, response);
				return;
			}
			
		}
		
		request.getRequestDispatcher("/views/Home.jsp").forward(request, response);
	}
	
	
	
	private void getShareVideo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String idVideo = request.getParameter("idVideo");
		String toMail =  request.getParameter("toEmail");
		Users user = (Users) request.getSession().getAttribute("user");
		Video video = videoDao.findById(idVideo);
		String link = getUrlServervoid(request, response)+idVideo;
		
		if (video!=null) {
			
			Share share = new Share();
			
			share.setUser(user);
			share.setVideo(video);
			share.setEmail(toMail);
			share.setShareDate(new Date());
			shareDao.insert(share);
			request.setAttribute("videoCurrent", video);
//			System.out.println(getUrlServervoid(request, response));
			MailHelper.ShareVideoToMail(toMail, user.getEmailUser(), idVideo, link);
			
		}
		
		
	}
	
	private String getUrlServervoid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StringBuffer URL = request.getRequestURL();
		URL.delete(URL.lastIndexOf("/"), URL.length());

		return URL.toString() + "/ActionVideoServlet/playvideo?idVideo=";
	}

}
