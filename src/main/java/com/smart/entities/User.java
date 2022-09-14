package com.smart.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User 
{
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int userId;
	private String userName;
	@Column(unique = true)
	private String userEmail;
	private String userPassword;
	@Column(length = 500)
	private String aboutUser;
	private String userImage;
	private String userRole;
	private boolean status;

	@OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.LAZY , mappedBy = "user")
	private List<Contact> contacts= new ArrayList<>();
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUserEmail() {
		return userEmail;
	}



	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}



	public String getUserPassword() {
		return userPassword;
	}



	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}



	public String getAboutUser() {
		return aboutUser;
	}



	public void setAboutUser(String aboutUser) {
		this.aboutUser = aboutUser;
	}



	public String getUserImage() {
		return userImage;
	}



	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}



	public String getUserRole() {
		return userRole;
	}



	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}



	public boolean isStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}

	

	public List<Contact> getContacts() {
		return contacts;
	}



	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", aboutUser=" + aboutUser + ", userImage=" + userImage + ", userRole=" + userRole
				+ ", status=" + status + ", contacts=" + contacts + "]";
	}



	
	
	
	
	
}
