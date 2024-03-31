package neko.com.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import neko.com.dao.VideoDAO;
import neko.com.model.Video;
import neko.com.ulti.ShareHelper;

/**
 * Servlet implementation class VideoManagerServlet
 */
@MultipartConfig
@WebServlet({ "/VideoManagerServlet", "/createVideo", "/updateVideo", "/DeleteVideo", "/RestVideoForm", "/EditVideo" })
public class VideoManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO videoDao = new VideoDAO();
	List<Video> dsVideo = videoDao.findAll();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VideoManagerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String uri = request.getRequestURI();

		if (request.getMethod().equalsIgnoreCase("post")) {

			if (uri.contains("createVideo")) {

				this.getCreateVideo(request, response);

				return;

			} else if (uri.contains("updateVideo")) {
				this.getUpdateVideo(request, response);

				return;

			} else if (uri.contains("DeleteVideo")) {
				this.getDeleteVideo(request, response);

				return;

			} else if (uri.contains("RestVideoForm")) {

			}

		}

		if (uri.contains("EditVideo")) {
			this.getEdit(request, response);
		}
		this.loadTable(request, response);
		request.getRequestDispatcher("/views/QuanLyVideo.jsp").forward(request, response);

	}

	private void getCreateVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Video video = new Video();
			BeanUtils.populate(video, request.getParameterMap());

			Video videoTemp = videoDao.findById(video.getIdVideo());
			Part imgPoster = request.getPart("poster");
			video.setPoster(imgPoster.getSubmittedFileName());

			if (videoTemp != null) {

				request.setAttribute("trungId", true);
				request.setAttribute("video", video);
				request.getRequestDispatcher("/views/QuanLyVideo.jsp").forward(request, response);
				return;
			}

			if(!imgPoster.getSubmittedFileName().trim().equals("")) {
				ShareHelper.saveImgToServer(request, response, imgPoster);
				
			}
			
		
			videoDao.insert(video);

			request.setAttribute("capNhat", true);
			this.loadTable(request, response);
			request.getRequestDispatcher("/views/QuanLyVideo.jsp").forward(request, response);

		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void getDeleteVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Video video = new Video();
			BeanUtils.populate(video, request.getParameterMap());

			Video videoTemp = videoDao.findById(video.getIdVideo());
			Part imgPoster = request.getPart("poster");
			video.setPoster(imgPoster.getSubmittedFileName());

			if (videoTemp == null) {

				request.setAttribute("KhongCoID", true);
				request.setAttribute("video", video);
				request.getRequestDispatcher("/views/QuanLyVideo.jsp").forward(request, response);
				return;
			}

			videoDao.delete(video.getIdVideo());
			request.setAttribute("capNhat", true);
			this.loadTable(request, response);
			request.getRequestDispatcher("/views/QuanLyVideo.jsp").forward(request, response);

		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void getUpdateVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Video video = new Video();
			BeanUtils.populate(video, request.getParameterMap());

			Video videoTemp = videoDao.findById(video.getIdVideo());
			Part imgPoster = request.getPart("poster");
			video.setPoster(imgPoster.getSubmittedFileName());

			if (videoTemp == null) {

				request.setAttribute("KhongCoID", true);
				request.setAttribute("video", video);
				request.getRequestDispatcher("/views/QuanLyVideo.jsp").forward(request, response);
				return;
			}
			
			if(!imgPoster.getSubmittedFileName().trim().equals("")) {
				ShareHelper.saveImgToServer(request, response, imgPoster);
				
			}
			

		
			videoDao.update(video);
			request.setAttribute("capNhat", true);
			this.loadTable(request, response);
			request.getRequestDispatcher("/views/QuanLyVideo.jsp").forward(request, response);

		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void getEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idVideo = request.getParameter("idVideo");
		Video video = videoDao.findById(idVideo);
		request.setAttribute("video", video);

	}

	private void loadTable(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dsVideo = videoDao.findAll();
		request.setAttribute("listVideo", dsVideo);
	}

}
