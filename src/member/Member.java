package member;

import java.util.Date;

public class Member {
	private long id;
	private String email;
	private String password;
	private String name;
	private Date regTime;

	public Member(Date date, String email2, String password2, String name2) {
		// TODO Auto-generated constructor stub
		super();
		this.regTime = date;
		this.email = email2;
		this.password = password2;
		this.name = name2;
	}

	public void changePassword(String op, String np) {
		if (op.equals(this.password)) {
			this.password = np;
		} else {
			throw new WrongPasswordException();
		}
	}

//	public 

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the regTime
	 */
	public Date getRegTime() {
		return regTime;
	}

	/**
	 * @param regTime the regTime to set
	 */
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

}
