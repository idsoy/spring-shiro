package org.llh.ssl.bean;

public class User {

	private String name;
	
	private String password;
	
	private Role role;
	
	public User(){};
	
	public User(String name, String pwd) {
		this.name = name;
		this.password = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
