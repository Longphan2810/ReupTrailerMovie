package neko.com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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

		if (arrCookies != null) {
			Comparator<Cookie> cmp = new Comparator<Cookie>() {

				@Override
				public int compare(Cookie o1, Cookie o2) {
					// TODO Auto-generated method stub

					if (o1.getName().equalsIgnoreCase("JSESSIONID") || o2.getName().equalsIgnoreCase("JSESSIONID")) {

						return 0;

					}
					if (o1.getName().equalsIgnoreCase("user") || o2.getName().equalsIgnoreCase("user")) {

						return 0;

					}
					if (o1.getName().equalsIgnoreCase("pass") || o2.getName().equalsIgnoreCase("pass")) {

						return 0;

					}
					if (Long.parseLong(o1.getValue()) > Long.parseLong(o2.getValue())) {

						return -1;
					} else if (Long.parseLong(o1.getValue()) < Long.parseLong(o2.getValue())) {

						return 1;
					} else {

						return 0;
					}
				}
			};

			Arrays.sort(arrCookies, cmp);

			for (int i = 0; i < arrCookies.length; i++) {
				Video videoTemp = videoDao.findById(arrCookies[i].getName());
				if (videoTemp != null) {
					listVuaXem.add(videoTemp);

				}

			}
		}

		request.getServletContext().setAttribute("listVuaXem", listVuaXem);

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

			Cookie cookieMovie = new Cookie(video.getIdVideo(), new Date().getTime() + "");
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
