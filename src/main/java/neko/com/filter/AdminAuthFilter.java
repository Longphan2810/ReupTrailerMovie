package neko.com.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neko.com.model.Users;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter({"/UserManagerServlet/*","/VideoManagerServlet/*","/ReportServlet","/ReportServlet/*"})
public class AdminAuthFilter extends HttpFilter  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		Users userCurrent = (Users) request.getSession().getAttribute("user");
		
		if(userCurrent==null ) {
			request.setAttribute("mess", "Vui lòng đăng nhập để sử dụng chức năng này !");
			request.getRequestDispatcher("/views/phanquyen/phanquyen.jsp").forward(request, response);
			return ;
		}
		if(!userCurrent.getAdmin()) {
			request.setAttribute("mess", "Chỉ admin mới có thể dùng chức năng này !");
			request.getRequestDispatcher("/views/phanquyen/phanquyen.jsp").forward(request, response);
			return ;
		}
				// pass the request along the filter chain
				chain.doFilter(request, response);
	}


}
