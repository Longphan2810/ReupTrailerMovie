import neko.com.dao.XacMinhDAO;
import neko.com.ulti.MailHelper;

public class test {

	public static void main(String[] args) {
		
		MailHelper mailHelper = new MailHelper();
		
		mailHelper.sendGetCodeToMail("phannhatlong44@gmail.com");
	
		
//		XacMinhDAO xmDao = new XacMinhDAO();
//		
//		xmDao.insert("phannhatlong44@gmail.com", 989898);
	}
	
}
