package neko.com.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import neko.com.dao.FavoriteDAO;
import neko.com.dao.UserDAO;
import neko.com.model.Favorite;
import neko.com.model.Users;
import neko.com.ulti.MailHelper;
import neko.com.ulti.RegisterHelper;

/**
 * Servlet implementation class LoginAndRegisterServlet
 */
@WebServlet({ "/Login", "/Register", "/logout" })
public class LoginAndRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FavoriteDAO favoriteDao = new FavoriteDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginAndRegisterServlet() {
		super();
		// TODO Auto-generated constructor stub

	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String uri = request.getRequestURI();

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {

			for (Cookie cookie : cookies) {

				if (cookie.getName().equals("user")) {
					request.setAttribute("CookieUser", cookie.getValue());
				}
				if (cookie.getName().equals("pass")) {
					request.setAttribute("CookiePass", cookie.getValue());
				}
			}
		}	

		if (request.getMethod().equalsIgnoreCase("post")) {

			if (uri.contains("Register")) {
				this.getRegister(request, response);
				return;
			} else if (uri.contains("Login")) {

				this.getLogin(request, response);
				return;
			}
		}
		if (uri.contains("logout")) {

			this.getLogOut(request, response);
			return;
		}

		request.getRequestDispatcher("/views/Login&Register.jsp").forward(request, response);

	}

	private void getLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDAO userDao = new UserDAO();
		String inputMail = request.getParameter("mail");
		String inputPass = request.getParameter("pass");
		String remeber = request.getParameter("remember");

		Users user = userDao.findUsersByEmail(inputMail);
		
		
		// check user
		if (user == null) {
			request.setAttribute("saiMail", true);
			

		} else {
			// if user ban
			System.out.println("dell null  " + user.toString());
			
			if (user.getStatus().equalsIgnoreCase("ban")) {

				request.setAttribute("ban", true);
			}
			// check pass
			if (user.getPassword().equals(inputPass) && user.getStatus().equalsIgnoreCase("active")) {
				// save cookie remember
				if (remeber != null) {

					Cookie cookieUser = new Cookie("user", inputMail);
					Cookie cookiePass = new Cookie("pass", inputPass);

					cookiePass.setMaxAge(60 * 60 * 24 * 3);
					cookieUser.setMaxAge(60 * 60 * 24 * 3);

					response.addCookie(cookieUser);
					response.addCookie(cookiePass);

				} else {

					Cookie cookieUser = new Cookie("user", inputMail);
					Cookie cookiePass = new Cookie("pass", inputPass);

					cookiePass.setMaxAge(0);
					cookieUser.setMaxAge(0);

					response.addCookie(cookieUser);
					response.addCookie(cookiePass);
				}

				// load data myFavorite in sessionScope
				List<Favorite> listMyFavorite = favoriteDao.SeleteByIdUser(user.getEmailUser());
				request.getSession().setAttribute("listMyFavorite", listMyFavorite);

				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("/views/Home.jsp").forward(request, response);
				return;
			} else {
				System.out.println(user.getPassword());
				System.out.println(user.getToken());
				request.setAttribute("saiPass", true);

			}
			
			

		}

		// return data to form
		request.setAttribute("emailOut", inputMail);
		request.setAttribute("passOut", inputPass);

		request.setAttribute("currentAction", "Login");
		request.getRequestDispatcher("/views/Login&Register.jsp").forward(request, response);

	}

	private void getLogOut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getSession().setAttribute("user", null);
		request.getRequestDispatcher("/views/Home.jsp").forward(request, response);

	}

	private void getRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    UserDAO userDao = new UserDAO();
		String checkName = "^[a-zA-Z ]*$";
		String mail = request.getParameter("emailUser");
		String passConfirm = request.getParameter("passwordConfirm");
		// check mail in system
		Users user = new Users();
		try {
			BeanUtils.populate(user, request.getParameterMap());

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!user.getFullname().matches(checkName)) {

			request.setAttribute("validName", true);
			request.setAttribute("user", user);
			request.setAttribute("passConfirm", passConfirm);
			request.setAttribute("currentAction", "Register");
			request.getRequestDispatcher("/views/Login&Register.jsp").forward(request, response);
			return;
		}

		if (user.getPassword().length() < 8) {

			request.setAttribute("shortPass", true);
			request.setAttribute("user", user);
			request.setAttribute("passConfirm", passConfirm);
			request.setAttribute("currentAction", "Register");
			request.getRequestDispatcher("/views/Login&Register.jsp").forward(request, response);
			return;
		}

		if (!user.getPassword().equals(passConfirm)) {

			request.setAttribute("difPass", true);
			request.setAttribute("user", user);
			request.setAttribute("passConfirm", passConfirm);
			request.setAttribute("currentAction", "Register");
			request.getRequestDispatcher("/views/Login&Register.jsp").forward(request, response);
			return;
		}

		if (userDao.findUsersByEmail(mail)==null) {
			RegisterHelper.setupToken(user);
			userDao.insert(user);
			String linkConfirm = this.getUrlServervoid(request, response) + user.getToken();
			MailHelper.sendConfirmToMail(mail, linkConfirm);
			request.setAttribute("okMail", true);

		} else {

			request.setAttribute("trungMail", true);
		}

		request.setAttribute("user", user);
		request.setAttribute("passConfirm", passConfirm);
		request.setAttribute("currentAction", "Register");
		request.getRequestDispatcher("/views/Login&Register.jsp").forward(request, response);
	}

	private String getUrlServervoid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StringBuffer URL = request.getRequestURL();
		URL.delete(URL.lastIndexOf("/"), URL.length());

		return URL.toString() + "/ConfirmAccount?TokenUser=";
	}

}
