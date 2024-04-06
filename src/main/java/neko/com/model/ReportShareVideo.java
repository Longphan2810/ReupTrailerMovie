package neko.com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReportShareVideo {

	@Id
	private String nguoiGui;
	private String emailGui;
	private String emailNhan;
	private Date dateGui;
	public ReportShareVideo(String nguoiGui, String emailGui, String emailNhan, Date dateGui) {
		super();
		this.nguoiGui = nguoiGui;
		this.emailGui = emailGui;
		this.emailNhan = emailNhan;
		this.dateGui = dateGui;
	}
	public ReportShareVideo() {
		super();
	}
	public String getNguoiGui() {
		return nguoiGui;
	}
	public void setNguoiGui(String nguoiGui) {
		this.nguoiGui = nguoiGui;
	}
	public String getEmailGui() {
		return emailGui;
	}
	public void setEmailGui(String emailGui) {
		this.emailGui = emailGui;
	}
	public String getEmailNhan() {
		return emailNhan;
	}
	public void setEmailNhan(String emailNhan) {
		this.emailNhan = emailNhan;
	}
	public Date getDateGui() {
		return dateGui;
	}
	public void setDateGui(Date dateGui) {
		this.dateGui = dateGui;
	}
	@Override
	public String toString() {
		return "ReportShareVideo [nguoiGui=" + nguoiGui + ", emailGui=" + emailGui + ", emailNhan=" + emailNhan
				+ ", dateGui=" + dateGui + "]";
	}
	
	

}
