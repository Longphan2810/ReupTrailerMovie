package neko.com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neko.com.dao.UserDAO;
import neko.com.model.Users;

/**
 * Servlet implementation class EditProfileAndChangesPassServlet
 */
@WebServlet({ "/UserChanges/EditProfile", "/UserChanges/ChangesPass" })
public class EditProfileAndChangesPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDao = new UserDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditProfileAndChangesPassServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		if (request.getMethod().equalsIgnoreCase("post")) {
			if (uri.contains("/UserChanges/EditProfile")) {

				getEditProfile(request, response);
				return;
			} else if (uri.contains("/UserChanges/ChangesPass")) {

				getChangesPass(request, response);
				return;
			}
		}
		
		if (request.getMethod().equalsIgnoreCase("get")) {
			if (uri.contains("/UserChanges/EditProfile")) {

				request.getRequestDispatcher("/views/EditProfile.jsp").forward(request, response);
				return;
			} else if (uri.contains("/UserChanges/ChangesPass")) {
				request.getRequestDispatcher("/views/ChangePass.jsp").forward(request, response);
			
				return;
			}
		}

		request.getRequestDispatcher("/views/EditProfile.jsp").forward(request, response);

	}

	private void getEditProfile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String emailUser = request.getParameter("emailUser");
		String passUser = request.getParameter("password");

		if (emailUser != null) {

			Users user = userDao.findUsersByEmail(emailUser);

			if (user.getPassword().equals(passUser)) {

				if (validForm(request, response)) {
					user.setAddress(request.getParameter("address").trim());
					user.setPhone(request.getParameter("phone").trim());
					user.setFullname(request.getParameter("fullname").trim());
					userDao.update(user);
					request.setAttribute("okUpdate", true);
					request.getSession().setAttribute("user", user);
					request.getRequestDispatcher("/views/EditProfile.jsp").forward(request, response);
					return;
				}

			} else {

				request.setAttribute("PassFail", true);

			}

		}

		request.getRequestDispatcher("/views/EditProfile.jsp").forward(request, response);

	}

	private void getChangesPass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Users user = (Users) request.getSession().getAttribute("user");
		String passOld = request.getParameter("pass");
		String passNew = request.getParameter("newPass");
		String passConfirm = request.getParameter("confirmPass");

		if (!user.getPassword().equals(passOld)) {
			request.setAttribute("FailPass", true);
			request.getRequestDispatcher("/views/ChangePass.jsp").forward(request, response);
			return;
		}

		if (passNew.length() < 8) {

			request.setAttribute("ShortPass", true);
			request.getRequestDispatcher("/views/ChangePass.jsp").forward(request, response);
			return;

		}
		if (!passNew.equals(passConfirm)) {
			
			
			request.setAttribute("DiffPass", true);
			request.getRequestDispatcher("/views/ChangePass.jsp").forward(request, response);
			return;

		}
		
		user.setPassword(passConfirm);
		userDao.update(user);
		request.setAttribute("okUpdate", true);
		request.getSession().setAttribute("user", user);
		request.getRequestDispatcher("/views/ChangePass.jsp").forward(request, response);

	}

	private boolean validForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String checkName = "^[a-zA-Z ]*$";
		String checkPhone = "\\d{10,11}";
		String phoneUser = request.getParameter("phone");
		String nameUser = request.getParameter("fullname");
		boolean totalCheck = true;
		if (!phoneUser.trim().matches(checkPhone)) {
			request.setAttribute("PhoneValid", true);
			System.out.println("ok");
			totalCheck = false;
		}
		if (!nameUser.matches(checkName)) {
			request.setAttribute("validName", true);
			System.out.println("ok");
			totalCheck = false;
		}
		return totalCheck;
	}

}
