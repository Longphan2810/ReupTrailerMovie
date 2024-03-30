package neko.com.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the XacMinh database table.
 * 
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "mail" }))
@NamedQuery(name="XacMinh.findAll", query="SELECT x FROM XacMinh x")
public class XacMinh implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String mail;

	private int codeXacMinh;

	public XacMinh() {
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getCodeXacMinh() {
		return this.codeXacMinh;
	}

	public void setCodeXacMinh(int codeXacMinh) {
		this.codeXacMinh = codeXacMinh;
	}

}