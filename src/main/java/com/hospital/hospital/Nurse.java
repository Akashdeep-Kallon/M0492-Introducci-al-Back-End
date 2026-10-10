package com.hospital.hospital;
public class Nurse {

	private String user;
	private String pw;
	private String name;

	public Nurse() {
	}

	public Nurse(String name, String user, String pw) {
		this.name = name;
		this.user = user;
		this.pw = pw;
	}

	public String getUser() {
		return user;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}
}
