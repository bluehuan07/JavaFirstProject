package model;

import java.io.Serializable;

public class People implements Serializable {
	private Integer idpeople;
	private String username;
	private String password;
	private String name;
	private String address1;
	private String address2;
	private String birthday;
	private String tel;
	private String level;

	public People() {
		super();
		// TODO Auto-generated constructor stub
	}

	public People(String username, String password, String name, String address1, String address2, String birthday,
			String tel) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.address1 = address1;
		this.address2 = address2;
		this.birthday = birthday;
		this.tel = tel;
	}

	public People(String username, String password, String name, String address1, String address2, String birthday,
			String tel, String level) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.address1 = address1;
		this.address2 = address2;
		this.birthday = birthday;
		this.tel = tel;
		this.level = level;
	}

	public Integer getIdpeople() {
		return idpeople;
	}

	public void setIdpeople(Integer idpeople) {
		this.idpeople = idpeople;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
