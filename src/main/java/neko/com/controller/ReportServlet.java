package neko.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neko.com.dao.ReportDAO;
import neko.com.model.reportFavorites;

/**
 * Servlet implementation class ReportServlet
 */
@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReportDAO reportDao = new ReportDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		
		fillDataReportFavorites(request, response);
		request.getRequestDispatcher("/views/BaoCao.jsp").forward(request, response);
	}
	
	
	private void fillDataReportFavorites(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<reportFavorites> listReportFavorite = reportDao.getListFavorite();
		request.setAttribute("listReportFavorite", listReportFavorite);
	}
	

}
