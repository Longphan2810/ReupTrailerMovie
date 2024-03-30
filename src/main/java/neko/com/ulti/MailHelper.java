package neko.com.ulti;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import neko.com.dao.XacMinhDAO;

public class MailHelper {
	private XacMinhDAO xacMinhDao = new XacMinhDAO();
	private String template;

	public boolean sendGetCodeToMail(String toEmail) {
		try {
			// set up template and code
			this.setUpTemplate("http://localhost:8080/ReupTrailerMovie/Register");

			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.ssl.protocols", "TLSv1.2");
			props.put("mail.smtp.starttls.enable", "true");
			String accountName = "phannhatlong44@gmail.com";
			String accountPassword = "yhuc rnjr fmrc czos";

			Session s = Session.getInstance(props, new javax.mail.Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(accountName, accountPassword);
				}
			});
			s.getProperties().put("mail.smtp.ssl.trust", "smtp.gmail.com");
			String from = "phannhatlong44@gmail.com";
			String to = toEmail;
			String subject = "Neko Company !!!";

			Message msg = new MimeMessage(s);
			msg.setFrom(new InternetAddress(from));
			msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(to));
			msg.setSubject(subject);
			msg.setContent(template, "text/html");
			Transport.send(msg);

			

		} catch (MessagingException ex) {
			System.out.println(ex.getMessage());
			return false;

		} catch (NullPointerException e) {

			System.out.println(e.getMessage());
			return false;
		}

		return true;
	}

	private void setUpTemplate(String hrefDieuHuong) {

		template = "<td align=\"left\" style=\"border-collapse:collapse;padding:20px 0px\" valign=\"top\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse;width:100%\" width=\"100%\"> <tbody> <tr> <td valign=\"top\" style=\"border-collapse:collapse\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td style=\"border-collapse:collapse;padding:0px\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td bgcolor=\"#ffffff\" style=\"border-collapse:collapse;padding:20px 0px 0px;border-radius:0px\" valign=\"top\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td align=\"center\" style=\"border-collapse:collapse;padding:20px 0px\" valign=\"top\"><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse;margin-right:auto;margin-left:auto\"><tbody><tr><td align=\"center\" valign=\"top\" style=\"border-collapse:collapse;padding:10px 0px 0px;line-height:28.08px;letter-spacing:-0.2px;font-family:Inter,Helvetica,Arial,sans-serif;font-size:18px;font-weight:600;color:rgb(247,147,26);text-align:center;text-align-last:center\"><div><font size=\"6\">NekoMovie</font></div></td></tr></tbody></table></td> </tr> </tbody> </table> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse;width:100%\" width=\"100%\"> <tbody> <tr> <td valign=\"top\" style=\"border-collapse:collapse\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr>  <td height=\"1\" style=\"border-collapse:collapse;line-height:1px;font-size:1px;border-bottom:1px solid rgba(255,255,255,0.15)\" valign=\"top\">&nbsp;</td> </tr> </tbody> </table> </td> </tr> </tbody> </table> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr>  </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> <tr> <td valign=\"top\" style=\"border-collapse:collapse\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td style=\"border-collapse:collapse;padding:0px\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td bgcolor=\"#ffffff\" style=\"border-collapse:collapse;padding:25px 40px 0px;border-radius:0px\" valign=\"top\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td align=\"center\" valign=\"top\" style=\"border-collapse:collapse\"></td> </tr> </tbody> </table> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td align=\"center\" style=\"border-collapse:collapse;padding:0px\" valign=\"top\"> <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse;margin-right:auto;margin-left:auto\"> <tbody> <tr> <td align=\"center\" style=\"border-collapse:collapse;padding:20px 0px 0px;line-height:131%;font-family:Inter,Helvetica,Arial,sans-serif;font-size:24px;font-weight:600;color:rgb(0,0,0);text-align:center;text-align-last:center\" valign=\"top\"> <div><img data-emoji=\"📉\" class=\"an1\" alt=\"📉\" aria-label=\"📉\" draggable=\"false\" src=\"https://fonts.gstatic.com/s/e/notoemoji/15.0/1f4c9/32.png\" loading=\"lazy\">&nbsp;Xac Minh Tai Khoan &nbsp;</div> </td> </tr>\r\n"
				+ "<tr> <td align=\"center\" style=\"font-size:0px;padding:5px 5px 5px 5px;word-break:break-word\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:separate;line-height:100%\"> <tbody> <tr> <td align=\"center\" bgcolor=\"#FCD535\" role=\"presentation\" style=\"border:none;border-radius:3px;background:#fcd535\" valign=\"middle\"> "
				+ "<a href=\"  "+hrefDieuHuong+"   \" "
				+ "style=\"display:inline-block;background:#fcd535;color:#000000;font-family:BinancePlex,Arial,PingFangSC-Regular,'Microsoft YaHei',sans-serif;font-size:14px;font-weight:700;line-height:15px;margin:0;text-decoration:none;text-transform:none;padding:10px 25px;border-radius:3px\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=http://post.eu.spmailtechnol.com/f/a/Sdp_P4QfFQZjhK1oReONbg~~/AAA5zgA~/RgRn58vDP4RbAWh0dHBzOi8vbG9nLmJudHJhY2UuY29tL2JhcGkvY29tcG9zaXRlL3YxL3B1YmxpYy9tZXNzYWdlL3ZpZXctdXJsP19iRXQ9ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKamRDSTZJbUVpTENKaUlqb2lNVEF3TmpneU1qQXdNREF5TkNJc0luSWlPaUpvZEhSd2N6b3ZMM2QzZHk1aWFXNWhibU5sTG1OdmJTOTJhUzloWTNScGRtbDBlUzlqYUdGc2JHVnVaMlV0WTI5dGNHVjBhWFJwYjI0dlFrNHhPVGMwTVRZNU56Z3lORFUzTlRBNU9ESTFJaXdpY3lJNklrTlNUU0lzSW5ObGNTSTZNVFExTmpZNUxDSjBjeUk2TVRjeE1UWXlNVGd5TnpNek9IMC42RmZDU3RBTUlkUXdEX2tMamlzcVlhWHRqeXJTTGFmY1h0em11d1RuRHpZVwVzcGNldUIKZfzDRgVmfFTBj1IYcGhhbm5oYXRsb25nNDRAZ21haWwuY29tWAQAAAAA&amp;source=gmail&amp;ust=1711903448432000&amp;usg=AOvVaw1MJjcp4jvYge5CE5bM1bOr\">                Xác Minh              </a> </td> </tr> </tbody> </table> </td> </tr>\r\n"
				+ "\r\n"
				+ "</tbody> </table></td> </tr> </tbody> </table> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td align=\"center\" style=\"border-collapse:collapse;padding:0px 0px 20px\" valign=\"top\"> <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse;margin-right:auto;margin-left:auto\"> <tbody> <tr> <td align=\"center\" style=\"border-collapse:collapse;padding:10px 0px 0px;line-height:156%;letter-spacing:-0.2px;font-family:Inter,Helvetica,Arial,sans-serif;font-size:18px;font-weight:600;color:rgb(247,147,26);text-align:center;text-align-last:center\" valign=\"top\"> <div>&nbsp;Chi co hieu luc trong vong 10p !</div></td></tr></tbody></table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> <tr> <td valign=\"top\" style=\"border-collapse:collapse\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td style=\"border-collapse:collapse;padding:0px\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr>  </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> <tr> <td valign=\"top\" style=\"border-collapse:collapse\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td style=\"border-collapse:collapse;padding:0px\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td bgcolor=\"#ffffff\" style=\"border-collapse:collapse;padding:40px 40px 10px;border-radius:0px\" valign=\"top\"> <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse\"> <tbody> <tr> <td align=\"left\" style=\"border-collapse:collapse;line-height:21px;font-family:Inter,Helvetica,Arial,sans-serif;font-size:15px;color:rgb(0,0,0);text-align-last:left\" valign=\"top\"> <div><span style=\"color:rgb(18,29,51)\">This price was correct at the time of sending this email.</span></div> <div><span style=\"color:rgb(18,29,51)\">This email was sent on: Mar 29, 2024</span></div> <div style=\"text-align:center\"></div> <div><span style=\"font-size:10px;color:rgb(18,29,51);line-height:21px\">Important note: The price quoted in this email was accurate at the time it was sourced. However, due to the intraday volatility of BTC, the price may have moved significantly between the time it was sourced and the time you received and/or read the email. Any data, text or other content is provided as general market information and is not investment advice. Do not act in reliance on it. Past performance is not necessarily an indicator of future results.</span></div> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> <tr> <td valign=\"top\" style=\"border-collapse:collapse\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td style=\"border-collapse:collapse;padding:0px\"><br> </td> </tr> </tbody> </table> </td> </tr> <tr> <td valign=\"top\" style=\"border-collapse:collapse\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td style=\"border-collapse:collapse;padding:0px\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td bgcolor=\"#ffffff\" style=\"border-collapse:collapse;padding:10px 40px;border-radius:0px\" valign=\"top\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse;width:100%\" width=\"100%\"> <tbody> <tr> <td valign=\"top\" style=\"border-collapse:collapse\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr>  <td height=\"1\" style=\"border-collapse:collapse;line-height:1px;font-size:1px;border-bottom:2px solid rgb(217,217,217)\" valign=\"top\">&nbsp;</td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> <tr> <td valign=\"top\" style=\"border-collapse:collapse\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td style=\"border-collapse:collapse;padding:0px\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td bgcolor=\"#ffffff\" style=\"border-collapse:collapse;padding:40px 40px 10px;border-radius:0px\" valign=\"top\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td align=\"center\" style=\"border-collapse:collapse;padding:0px 0px 20px\"> <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse\"> <tbody> <tr> <td style=\"border-collapse:collapse;padding:0px 15px 0px 0px\" valign=\"middle\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse\"> <tbody> <tr> <td align=\"center\" valign=\"middle\" style=\"border-collapse:collapse\"> <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse\"> <tbody> <tr> <td align=\"center\" valign=\"top\" style=\"border-collapse:collapse\"> <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse\"> <tbody> <tr> <td valign=\"top\" style=\"border-collapse:collapse\"> <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse\"> <tbody> <tr> <td align=\"left\" valign=\"top\" style=\"border-collapse:collapse\"><a href=\"https://www.facebook.com/2810pnl\" rel=\"noopener\" style=\"text-decoration-line:none;text-align-last:left\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.facebook.com/2810pnl&amp;source=gmail&amp;ust=1711903812494000&amp;usg=AOvVaw0eSxaNvrW3iJIYLxy-pXzx\"> <img alt=\"\" height=\"20\" src=\"https://ci3.googleusercontent.com/meips/ADKq_NY18gflT5rlDMY46cieOzttF2MCKsAPFQO8bDEk1CG9RK7Bf1I0wvHvLKlPNWMrAXFoPSZjHZC2Ior68SKkAq95RA0q4qJ3PI78bx6RNlESNtXFZ9tpy2XNwaqx2xA=s0-d-e1-ft#https://s1.designmodo.com/postcards/f4f8367a140e4d98c6875716009cdcac.png\" style=\"display:block;border:0px;outline:0px;line-height:100%;width:20px;height:auto;max-width:100%\" width=\"20\" class=\"gmail_canned_response_image\"> </a></td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td>  <td style=\"border-collapse:collapse;padding:0px 15px\" valign=\"middle\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse\"> <tbody> <tr> <td align=\"center\" valign=\"middle\" style=\"border-collapse:collapse\"> <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse\"> <tbody> <tr> <td align=\"center\" valign=\"top\" style=\"border-collapse:collapse\"> <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse\"> <tbody> <tr> <td valign=\"top\" style=\"border-collapse:collapse\"> <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse\"> <tbody> <tr> <td align=\"left\" valign=\"top\" style=\"border-collapse:collapse\"><a href=\"https://www.instagram.com/pii_2810/\" rel=\"noopener\" style=\"text-decoration-line:none;text-align-last:left\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.instagram.com/pii_2810/&amp;source=gmail&amp;ust=1711903812494000&amp;usg=AOvVaw1NCYXoFiC1nVRIVmIV39zv\"> <img alt=\"\" height=\"19\" src=\"https://ci3.googleusercontent.com/meips/ADKq_NbLS4SQJxMvh_eUyfeuqZKU2r0nUrFQjjPCWzeTfJ9Unsjk2EoiTZ_C0ImQlXt7LbWFnEu-9phaqWLG85jIBbd_OKVz1Z6k_CaMcDc3Z-aRGeWfdHAdGCAfk2w7uvw=s0-d-e1-ft#https://s1.designmodo.com/postcards/f6bfefc6090349c90894ed28437647f7.png\" style=\"display:block;border:0px;outline:0px;line-height:100%;width:20px;height:auto;max-width:100%\" width=\"20\" class=\"gmail_canned_response_image\"> </a></td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> <td style=\"border-collapse:collapse;padding:0px 0px 0px 15px\" valign=\"middle\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse\"> <tbody> <tr> <td align=\"center\" valign=\"middle\" style=\"border-collapse:collapse\"> <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse\"> <tbody> <tr> <td align=\"center\" valign=\"top\" style=\"border-collapse:collapse\"> <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse\"> <tbody> <tr> <td valign=\"top\" style=\"border-collapse:collapse\"> <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse\"> <tbody> <tr> <td align=\"left\" valign=\"top\" style=\"border-collapse:collapse\"><a href=\"http://links.blockchain.com/u/click?_t=b077a02c6d894ec28e56236cee81e43a&amp;_m=0c1285013b0942d394fe2b03c361fcd4&amp;_e=XjCR3B2xPBX9sc7GL-aVuIApmQXZLbkOwwdzuJWuETTrCdOTZtkhUtuvkXqjwgTZwjKuXXUVOfFe696AVWhN64uhqCvAYy6hpYs4w1U2Wi1xw23dTC9q9P-CbcEjqBYTS9gkau0NBQiJjP1Rx3PJ0KRgUuouw1XQL692mYV1ZbTHiQxAdV9T2HzVr42S0wQnP2DHwO-FJG3c9bSVo639s1NIIIMMpKjS0KfGLA1KC_4%3D\" rel=\"noopener\" style=\"text-decoration-line:none;text-align-last:left\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=http://links.blockchain.com/u/click?_t%3Db077a02c6d894ec28e56236cee81e43a%26_m%3D0c1285013b0942d394fe2b03c361fcd4%26_e%3DXjCR3B2xPBX9sc7GL-aVuIApmQXZLbkOwwdzuJWuETTrCdOTZtkhUtuvkXqjwgTZwjKuXXUVOfFe696AVWhN64uhqCvAYy6hpYs4w1U2Wi1xw23dTC9q9P-CbcEjqBYTS9gkau0NBQiJjP1Rx3PJ0KRgUuouw1XQL692mYV1ZbTHiQxAdV9T2HzVr42S0wQnP2DHwO-FJG3c9bSVo639s1NIIIMMpKjS0KfGLA1KC_4%253D&amp;source=gmail&amp;ust=1711903812494000&amp;usg=AOvVaw3Ktqe490OIej5Kqf8Y10Yg\"> <br> </a></td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td align=\"center\" style=\"border-collapse:collapse\"> <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse\"> <tbody> <tr> <td style=\"border-collapse:collapse;padding:0px\" valign=\"top\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse\"> <tbody> <tr> <td align=\"center\" valign=\"top\" style=\"border-collapse:collapse\"> <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse\"> <tbody> <tr> <td align=\"center\" valign=\"top\" style=\"border-collapse:collapse\"></td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> <tr> <td valign=\"top\" style=\"border-collapse:collapse\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td style=\"border-collapse:collapse;padding:0px\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td bgcolor=\"#ffffff\" style=\"border-collapse:collapse;padding:10px 40px 40px;border-radius:0px\" valign=\"top\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td style=\"border-collapse:collapse\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td align=\"center\" valign=\"top\" style=\"border-collapse:collapse\"> <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"border-collapse:collapse\"> <tbody> <tr> <th style=\"border-collapse:collapse;font-weight:normal;text-align:left\" valign=\"top\" align=\"left\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td valign=\"top\" style=\"border-collapse:collapse\"><a href=\"mailto:Phannhatlong44@gmail.com\" rel=\"noopener\" style=\"text-decoration-line:none\" target=\"_blank\"> <img alt=\"\" height=\"52\" src=\"https://ci3.googleusercontent.com/meips/ADKq_NZi7c2kdeyUXgJmi93BJWgpawW7M9jP8nT7WOWHdS955S6XD0X9gGAmQyBEH3E69KTOhiHo8-8d8xe_yC0nd4gEbUVSiZfqsXYfEhZj7s7i4-9j=s0-d-e1-ft#https://s1.designmodo.com/postcards/button-app-store-dark.png\" style=\"display:block;border:0px;outline:0px;line-height:100%;width:127px;height:auto;max-width:100%\" width=\"127\" class=\"gmail_canned_response_image\"> </a></td> </tr> </tbody> </table> </th> <th style=\"border-collapse:collapse;font-weight:normal;text-align:left\" valign=\"top\" align=\"left\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td style=\"border-collapse:collapse;padding:0px 0px 0px 15px\" valign=\"top\"><a href=\"mailto:Phannhatlong44@gmail.com\" rel=\"noopener\" style=\"text-decoration-line:none\" target=\"_blank\"> <img alt=\"\" height=\"52\" src=\"https://ci3.googleusercontent.com/meips/ADKq_NYBeG24QalgWB20_c2iB2WI-wLADTth_d8hrPbs-5wy1QZouQ5c3xnakbwQCjZJocsjMbSilwIkNvcMT3O1pNUdcMXIug6LQ98hlPLmKySHkMblpFg=s0-d-e1-ft#https://s1.designmodo.com/postcards/button-google-play-dark.png\" style=\"display:block;border:0px;outline:0px;line-height:100%;width:136px;height:auto;max-width:100%\" width=\"136\" class=\"gmail_canned_response_image\"> </a></td> </tr> </tbody> </table> </th> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> <tr> <td valign=\"top\" style=\"border-collapse:collapse\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td style=\"border-collapse:collapse;padding:0px\"></td></tr></tbody></table></td></tr><tr><td valign=\"top\" style=\"border-collapse:collapse\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"><tbody><tr><td style=\"border-collapse:collapse;padding:0px\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"><tbody><tr><td bgcolor=\"#dfe3eb\" style=\"border-collapse:collapse;padding:20px 40px;border-radius:0px;background-color:rgb(223,227,235)\" valign=\"top\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"><tbody><tr><td style=\"border-collapse:collapse\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"><tbody><tr><td valign=\"top\" style=\"border-collapse:collapse\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"><tbody><tr><th style=\"border-collapse:collapse;font-weight:normal;text-align:left;width:50%\" valign=\"top\" width=\"50%\" align=\"left\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"><tbody><tr><td align=\"left\" style=\"border-collapse:collapse;padding:0px 20px 0px 0px\" valign=\"top\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"><tbody><tr><td valign=\"top\" style=\"border-collapse:collapse\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"><tbody> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </th> <th style=\"border-collapse:collapse;font-weight:normal;text-align:left;width:50%\" valign=\"top\" width=\"50%\" align=\"left\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td align=\"left\" style=\"border-collapse:collapse;padding:0px 0px 0px 20px\" valign=\"top\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr> <td valign=\"top\" style=\"border-collapse:collapse\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse\"> <tbody> <tr></tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </th> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td> </tr> </tbody> </table> </td>";
	}

}
