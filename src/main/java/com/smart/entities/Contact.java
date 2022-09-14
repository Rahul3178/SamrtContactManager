package com.smart.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Contact 
{
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int cId;
	private String custName;
	private String secondName;
	private String work;
	private String custEmail;
	private String phone;
	private String custImage;
	@Column(length=5000)
	private String aboutContact;
	
	
	@ManyToOne
	private User user;
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCustImage() {
		return custImage;
	}
	public void setCustImage(String custImage) {
		this.custImage = custImage;
	}
	public String getAboutContact() {
		return aboutContact;
	}
	public void setAboutContact(String aboutContact) {
		this.aboutContact = aboutContact;
	}
	
	@Override
	public String toString() {
		return "Contact [cId=" + cId + ", custName=" + custName + ", secondName=" + secondName + ", work=" + work
				+ ", custEmail=" + custEmail + ", phone=" + phone + ", custImage=" + custImage + ", aboutContact="
				+ aboutContact + "]";
	}
	
	
}
