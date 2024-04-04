package neko.com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neko.com.dao.VideoDAO;
import neko.com.model.Video;

/**
 * Servlet implementation class WatchVideoServlet
 */
@WebServlet("/ActionVideoServlet/playvideo")
public class ActionVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO videoDao = new VideoDAO();
	private List<Video> listVuaXem = new ArrayList<Video>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionVideoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		Cookie[] arrCookies = request.getCookies();
		listVuaXem.clear();
		for (int i = 0; i < arrCookies.length; i++) {
			Video videoTemp = videoDao.findById(arrCookies[i].getName());
			if (videoTemp != null) {
				listVuaXem.add(videoTemp);

			}
			

		}

		request.setAttribute("listVuaXem", listVuaXem);

		if (uri.contains("/ActionVideoServlet/playvideo")) {
			this.getPlayVideo(request, response);

		}

	}

	private void getPlayVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idVideoFromRequest = request.getParameter("idVideo");
		Video video = null;
		if (idVideoFromRequest != null) {

			video = videoDao.findById(idVideoFromRequest);
		}

		if (video != null) {

			Cookie cookieMovie = new Cookie(video.getIdVideo(), "");
			cookieMovie.setMaxAge(60 * 60 * 24 * 3);
			response.addCookie(cookieMovie);
			video.setViews(video.getViews() + 1);
			videoDao.update(video);
			request.setAttribute("videoCurrent", video);
			request.getRequestDispatcher("/views/Video.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/views/404/FileNotFound.jsp").forward(request, response);
		}

	}

}
