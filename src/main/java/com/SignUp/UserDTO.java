package com.SignUp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDTO {

	private String name;
	@Id
	private long mobile_num;
	private String gmail;
	private int age;
	private String password;
	private String gender;
	private String dob;
	private String address;
	private long altMobile_num;
	private String altGmail;
	private int otp;

	public UserDTO() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobile_num() {
		return mobile_num;
	}

	public void setMobile_num(long mobile_num) {
		this.mobile_num = mobile_num;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getPassword() {
		return password;
	}
	
	public String getPass1()
	{
		String s=getPassword();
		String emp="";
		if(s!=null)
		{
			for(int i=0;i<s.length();i++)
			{
				emp=emp+"*";
			}
		}
		return emp;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getAltMobile_num() {
		return altMobile_num;
	}

	public void setAltMobile_num(long altMobile_num) {
		this.altMobile_num = altMobile_num;
	}

	public String getAltGmail() {
		return altGmail;
	}

	public void setAltGmail(String altGmail) {
		this.altGmail = altGmail;
	}

	
	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		String res="Your name is :"+getName()+"\nYour Mobile_num is :"+getMobile_num()+"\nYour Gmail is :"
				+ getGmail()+"\nYour age is :"+getAge()+"\nYour gender is :"+getGender()+"\nYour dob is :"
				+getDob()+"\nYour address is :"+getAddress()+"\nyour altMobile is :"+getAltMobile_num();
		return res;
	}
	 
}