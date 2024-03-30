package neko.com.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import neko.com.dao.UserDAO;
import neko.com.model.Users;

/**
 * Servlet implementation class LoginAndRegisterServlet
 */
@WebServlet({"/Login","/Register"})
public class LoginAndRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDao = new UserDAO(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAndRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
        
        
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uri = request.getRequestURI();
	
		if(request.getMethod().equalsIgnoreCase("post")) {
		
		if(uri.contains("Register")) {
			this.getRegister(request, response);
			
		} else if(uri.contains("Login")) {
			
			this.getLogin(request, response);
		}
		}

		request.getRequestDispatcher("/views/Login&Register.jsp").forward(request, response);
	
	}
	
	private void getLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("currentAction", "Login");
	}
	
	private void getRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
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
		
		if( userDao.exists(mail)) {
			
			
			
		} else {
			
			request.setAttribute("trungMail", true);
		}
		
		System.out.println(user.toString());
		System.out.println(passConfirm);
		request.setAttribute("user", user);
		request.setAttribute("passConfirm", passConfirm);
		request.setAttribute("currentAction", "Register");
		
		
		
		
	}
	

}
