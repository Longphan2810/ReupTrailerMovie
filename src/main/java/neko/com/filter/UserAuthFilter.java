package neko.com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neko.com.model.Users;

/**
 * Servlet Filter implementation class UserAuthFilter
 */
@WebFilter({ "/UserChanges/*", "/FavoriteVideo/*", "/ShareVideo/*" })
public class UserAuthFilter extends HttpFilter implements Filter {

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response , FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		Users userCurrent = (Users) request.getSession().getAttribute("user");

		String uri = request.getRequestURI();
		
		
		if (userCurrent == null) {
			request.setAttribute("mess", "Vui lòng đăng nhập để sử dụng chức năng này !");
			request.getRequestDispatcher("/views/phanquyen/phanquyen.jsp").forward(request, response);
			return;
		}
		

		super.doFilter(request, response, chain);
	}

	
	
}
