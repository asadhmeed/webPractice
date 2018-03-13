package com.asad.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String userName;
	private String email;
	private String password;
	private boolean emailIsConfirmed;

	public UserEntity() {

	}

	public UserEntity(String userName, String email, String password, boolean emailIsConfirmed) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.emailIsConfirmed = emailIsConfirmed;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEmailIsConfirmed() {
		return emailIsConfirmed;
	}

	public void setEmailIsConfirmed(boolean emailIsConfirmed) {
		this.emailIsConfirmed = emailIsConfirmed;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", emailIsConfirmed=" + emailIsConfirmed + "]";
	}

}
