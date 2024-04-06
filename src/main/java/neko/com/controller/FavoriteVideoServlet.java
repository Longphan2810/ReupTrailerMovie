package neko.com.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import neko.com.dao.FavoriteDAO;
import neko.com.dao.UserDAO;
import neko.com.dao.VideoDAO;
import neko.com.model.Favorite;
import neko.com.model.Users;
import neko.com.model.Video;
import neko.com.ulti.HibernateUtil;

/**
 * Servlet implementation class FavoriteVideoServlet
 */
@WebServlet({ "/FavoriteVideo/home", "/FavoriteVideo/favorite","/FavoriteVideo/video" })
public class FavoriteVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO videoDao = new VideoDAO();
	private FavoriteDAO favoriteDao = new FavoriteDAO();
	private UserDAO userDao = new UserDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FavoriteVideoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();

		if (uri.contains("/FavoriteVideo/home")) {
			getLikeOrDislike(request, response);
			request.getRequestDispatcher("/views/Home.jsp").forward(request, response);
		} else if (uri.contains("/FavoriteVideo/favorite")) {
			getLikeOrDislike(request, response);
			request.getRequestDispatcher("/views/MyFavorite.jsp").forward(request, response);
		}else if (uri.contains("/FavoriteVideo/video")) {
			getLikeOrDislike(request, response);
			request.getRequestDispatcher("/views/Video.jsp").forward(request, response);
		}

	}

	private void getLikeOrDislike(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idVideo = request.getParameter("likeVideo");
		Users user = (Users) request.getSession().getAttribute("user");
		if (idVideo != null) {
			Video video = videoDao.findById(idVideo);
			if (video != null) {

				Favorite favorite = favoriteDao.findByIdUserAndIdVideo(user.getEmailUser(), video.getIdVideo());
				request.setAttribute("videoCurrent", video);
				if (favorite == null) {
					getLike(user, video);

					// load data myFavorite in sessionScope
					List<Favorite> listMyFavorite = favoriteDao.SeleteByIdUser(user.getEmailUser());
					request.getSession().setAttribute("listMyFavorite", listMyFavorite);

					System.out.println("da like");
				} else {

					getDisLike(favorite);

					// load data myFavorite in sessionScope
					List<Favorite> listMyFavorite = favoriteDao.SeleteByIdUser(user.getEmailUser());
					request.getSession().setAttribute("listMyFavorite", listMyFavorite);

					
					System.out.println("da diss like");
				}

			}

		}

	}

	private void getLike(Users user, Video video) {
		Favorite favorite = new Favorite();
		favorite.setUser(user);
		favorite.setVideo(video);
		System.out.println(video.toString());
		favorite.setLikeDate(new Date());
		favoriteDao.insert(favorite);
		System.out.println("ok");
	}

	private void getDisLike(Favorite favorite) {

		favoriteDao.delelte(favorite.getIdFavorite());
	}

}
