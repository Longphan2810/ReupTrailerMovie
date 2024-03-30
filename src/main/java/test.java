import java.util.Base64;
import java.util.Date;

import neko.com.dao.UserDAO;
import neko.com.dao.XacMinhDAO;
import neko.com.ulti.MailHelper;

public class test {

	public static void main(String[] args) {
		
		MailHelper mailHelper = new MailHelper();
		
		mailHelper.sendGetCodeToMail("phannhatlong44@gmail.com");
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
		
	
		
		if(userDao.exists("vana@gmai.com")) {
			System.out.println("x");
		} else {
			System.out.println("o");
		}
		
	}
	
}
