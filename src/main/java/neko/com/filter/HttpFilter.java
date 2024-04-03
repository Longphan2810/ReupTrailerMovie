package neko.com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HttpFilter extends Filter {

	@Override
	default void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		this.doFilter((HttpServletRequest) request, (HttpServletResponse) response);
		
	}

	public void doFilter(HttpServletRequest request,HttpServletResponse response) ;
	
	
	
}
