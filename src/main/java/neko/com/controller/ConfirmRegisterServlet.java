package neko.com.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neko.com.dao.UserDAO;
import neko.com.model.Users;

/**
 * Servlet implementation class ConfirmRegisterServlet
 */
@WebServlet("/ConfirmAccount")
public class ConfirmRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDao = new UserDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		Date currentDate = new Date();
			
			if(uri.contains("ConfirmAccount")) {
				
				String token = request.getParameter("TokenUser");
				Users user = userDao.findUsersByToken(token);
					// check status user
				if(user.getStatus().equalsIgnoreCase("wait")) {
					//check token time 
					if(user.getTimeToken()>currentDate.getTime()) {
						
						user.setToken("");
						user.setStatus("active");
						user.setTimeToken(0l);
						userDao.update(user);
						
						request.setAttribute("thanhCong", "Đăng ký thành công !");
					}  else {
						
						request.setAttribute("thanhCong", "Quá thời gian xác minh !");
					}	
					
				} else {
					request.setAttribute("thanhCong", "Liên kết đã được sử dụng trước đó !");
				}
				
				
				
				
			}
			
			
		
		
		request.getRequestDispatcher("/views/ConfirmAccount.jsp").forward(request, response);
		
	}
	
	
	
	
	

}
