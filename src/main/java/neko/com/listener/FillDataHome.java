package neko.com.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import neko.com.dao.VideoDAO;
import neko.com.model.Video;

/**
 * Application Lifecycle Listener implementation class FillDataHome
 *
 */
@WebListener
public class FillDataHome implements ServletContextListener {
	private VideoDAO videoDao = new VideoDAO();
    /**
     * Default constructor. 
     */
    public FillDataHome() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	ServletContext applycation = sce.getServletContext();
    	List<Video> danhSachVideo = videoDao.findAll();
    	applycation.setAttribute("listVideo", danhSachVideo);
    	
    }
	
}
