import java.util.Base64;
import java.util.Date;
import java.util.List;

import neko.com.dao.FavoriteDAO;
import neko.com.dao.ReportDAO;
import neko.com.dao.UserDAO;
import neko.com.dao.VideoDAO;
import neko.com.dao.XacMinhDAO;
import neko.com.model.Favorite;
import neko.com.model.ReportFavoritesUsers;
import neko.com.model.ReportShareVideo;
import neko.com.model.Users;
import neko.com.model.Video;
import neko.com.model.reportFavorites;
import neko.com.ulti.MailHelper;

public class test {

	public static void main(String[] args) {

//		MailHelper mailHelper = new MailHelper();
//		
//		mailHelper.sendGetCodeToMail("phannhatlong44@gmail.com");
//	

//		XacMinhDAO xmDao = new XacMinhDAO();
//		
//		xmDao.insert("phannhatlong44@gmail.com", 989898);

//		Base64.getEncoder().encodeToString("xxxxx");
//		String originalInput = "comMk1234annhatlong44@gmail.comMk1234annhatlong44@gmail.comMk12345";
//		String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
//		
//		System.out.println(encodedString);
//		
//		byte[] newEncodedString = Base64.getDecoder().decode(encodedString);
//		System.out.println(new String(encodedString));

//		
//		final long oneMinute = 60000;  
//		Date currentTime = new Date();
//		
//		System.out.println(currentTime.getTime()+oneMinute);

		UserDAO userDao = new UserDAO();
		
		Users user = userDao.findUsersByEmail("phannhatlong55@gmail.com");
		
		System.out.println("data 1 :" + user.getToken());
		user.setToken("");
		userDao.update(user);
		
		Users user2 = userDao.findUsersByEmail("phannhatlong55@gmail.com");
		
		System.out.println("data 2 :" + user2.getToken());
//	
//		
//		Users user = userDao.findUsersByEmail("phannhatlong44@gmail.com");
//		MailHelper.sendPassToMail("phannhatlong44@gmail.com", user.getPassword());
//		
//		if(userDao.exists("vana@gmai.com")) {
//			System.out.println("x");
//		} else {
//			System.out.println("o");
//		}
//		

//		String regex = "^[a-zA-Z ]*$";
//		String  name = "ng";
//		
//		if(name.matches(regex)) {
//			System.out.println("ok");
//			
//		} else {
//			System.out.println("cook");
//			
//		}

//		VideoDAO videoDao = new VideoDAO();
//		
//		List<Video> ds = videoDao.findTopViews();		
//		for (Video video : ds) {
//			System.out.println(video.toString());
//		}

		
//		ReportDAO reportDao = new ReportDAO();
//		
//		List<ReportShareVideo> ds = reportDao.getListShareVideo("KẺ ĐỘC HÀNH");
//		System.out.println("y");
//		for (ReportShareVideo reportFavorites : ds) {
//			System.out.println(reportFavorites.toString());
//			System.out.println("x");
//		}
		

	}

}
