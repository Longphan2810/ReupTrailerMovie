package neko.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neko.com.dao.UserDAO;
import neko.com.model.Users;

/**
 * Servlet implementation class UserManagerServlet
 */
@WebServlet({ "/UserManagerServlet/edit", "/UserManagerServlet/update", "/UserManagerServlet/delete",
		"/UserManagerServlet/reset" })
public class UserManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Users> listUser;
	private UserDAO userDao = new UserDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserManagerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		listUser = userDao.findAll();
		String uri = request.getRequestURI();

		if (uri.contains("/UserManagerServlet/edit")) {
			getEdit(request, response);
		}

		if(request.getMethod().equalsIgnoreCase("post")) {
			if (uri.contains("/UserManagerServlet/update")) {
				getUpdate(request, response);
			} else if (uri.contains("/UserManagerServlet/delete")) {
				getDelete(request, response);
			} else if (uri.contains("/UserManagerServlet/reset")) {
			}
			
		}
		
		
		request.setAttribute("listUser", listUser);
		request.getRequestDispatcher("/views/QuanLyNguoiDung.jsp").forward(request, response);
	}

	private void getEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idUser = request.getParameter("idEdit");
		Users user = null;
		if (idUser != null) {
			user = userDao.findUsersByEmail(idUser);
		}
		if (user != null) {
			request.setAttribute("CurrentUser", user);
			System.out.println("ok");
		}

	}

	private void getUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idUser = request.getParameter("emailUser");
		boolean adminUser = Boolean.parseBoolean(request.getParameter("admin"));
		Users user = null;
		if (idUser != null) {
			user = userDao.findUsersByEmail(idUser);
		}
		if (user == null) {
			request.setAttribute("saiMail", true);
			System.out.println("ok");
		} else {
			user.setAdmin(adminUser);
			userDao.update(user);
			request.setAttribute("okMail", true);
		}
		
	}

	private void getDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idUser = request.getParameter("emailUser");
		Users user = null;
		if (idUser != null) {
			user = userDao.findUsersByEmail(idUser);
		}
		if (user == null) {
			request.setAttribute("saiMail", true);
			System.out.println("ok");
		} else {
			userDao.delete(user.getEmailUser());
			request.setAttribute("okMail", true);
		}
	}

	
}
