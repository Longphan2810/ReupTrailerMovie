package neko.com.ulti;

import java.util.Base64;
import java.util.Date;

import neko.com.model.Users;

public class RegisterHelper {

	private static final long tenMinuteToMillisecond = 60000 * 10;

	public static void setupToken(Users user) {
		// get current date
		Date date = new Date();
		long finalTimeToken = date.getTime()+ tenMinuteToMillisecond;

		// create token
		String token = Base64.getEncoder().encodeToString(user.toString().getBytes());

		// add status 
		
		String status = "wait";
		
		user.setTimeToken(finalTimeToken);
		user.setToken(token);
		user.setStatus(status);
		
	

	}

}
