package neko.com.ulti;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class ShareHelper {

	
	public static void saveImgToServer(HttpServletRequest request, HttpServletResponse response,Part part)
			throws ServletException, IOException {
		
		File fileImg = new File(request.getServletContext().getRealPath("/imgPoster"));
		
		if(!fileImg.exists()) {
			fileImg.mkdirs();
			
		}
		
		
		File imgFileFromPart = new File(fileImg.getAbsoluteFile(), part.getSubmittedFileName());
		
		part.write(imgFileFromPart.getAbsolutePath());

		System.out.println(fileImg.getAbsolutePath());
	}

	public static void readImgToServer() {

	}

}
