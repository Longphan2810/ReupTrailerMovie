import java.util.Base64;
import java.util.Date;
import java.util.List;

import neko.com.dao.UserDAO;
import neko.com.dao.VideoDAO;
import neko.com.dao.XacMinhDAO;
import neko.com.model.Users;
import neko.com.model.Video;
import neko.com.ulti.MailHelper;

public class test {

	public static void main(String[] args) {
		
		MailHelper mailHelper = new MailHelper();
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
//		
//		Users user = userDao.findUsersByToken("VXNlcnMgW2VtYWlsVXNlcj1waGFubmhhdGxvbmc0NEBnbWFpbC5jb20sIGFkbWluPWZhbHNlLCBmdWxsbmFtZT1OZ3V5ZW4gVmFuIEIsIHBhc3N3b3JkPTEyMw==");
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
		
		VideoDAO videoDao = new VideoDAO();
		
		List<Video> ds = videoDao.findTopViews();		
		for (Video video : ds) {
			System.out.println(video.toString());
		}
	}
	
}
