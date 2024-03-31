package neko.com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neko.com.dao.UserDAO;
import neko.com.model.Users;
import neko.com.ulti.MailHelper;

/**
 * Servlet implementation class ForgotPassServlet
 */
@WebServlet("/ForgotPass")
public class ForgotPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDao = new UserDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		if(request.getMethod().equalsIgnoreCase("post")) {
			
			String inputMail = request.getParameter("mail");
			
			Users user = userDao.findUsersByEmail(inputMail);
			
			if(user!=null) {
			
			MailHelper.sendPassToMail(inputMail, user.getPassword());
			request.setAttribute("okMail", true);
			} else {
				request.setAttribute("saiMail", true);
			}
		}
		
		
		request.getRequestDispatcher("/views/ForgotPass.jsp").forward(request, response);
			
	}
	
	

}
