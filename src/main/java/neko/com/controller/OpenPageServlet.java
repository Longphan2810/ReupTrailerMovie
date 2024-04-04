package neko.com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OpenPageServlet
 */
@WebServlet({"/OpenPageServlet","/Home/page"})
public class OpenPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpenPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		if(uri.contains("/Home/page")) {
			this.getOpenHomePage(request, response);
			
		}
		
	}
	
	private void getOpenHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getParameter("numPage");
		
		if(page!=null && Integer.parseInt(page)>1) {
			
			request.setAttribute("ListEnd", Integer.parseInt(page)*7-6);
		} 
		request.setAttribute("CurrentPage", Integer.parseInt(page));
		request.getRequestDispatcher("/views/Home.jsp").forward(request, response);
	}

	
	

}
