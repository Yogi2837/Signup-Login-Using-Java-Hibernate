package com.profiles;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.sql.*;
import com.SignUp.*;
import com.validations.*;
public class UserProfile {
	
	Scanner sc=new Scanner(System.in);
	ValidateUpdatingDetails toValidate=new ValidateUpdatingDetails();
	
	private static EntityManagerFactory emf=Persistence.createEntityManagerFactory("toConnect");
	private static EntityManager em=emf.createEntityManager();
	private static EntityTransaction et=em.getTransaction();
	
	private  UserDTO dt=new UserDTO();
		
	public void showUserData(long num)
	{
		System.out.println("enter 1-to see Profile\n2-update profile\n3-delete profile");
		int enter=sc.nextInt();
		switch(enter)
		{
			case 1:
				seeProfile(num);
				break;
			case 2:
				updateProfile(num);
				break;
			case 3:
				deleteProfile(num);
		}
	}
	
	public  void seeProfile(long num)
	{

		UserDTO dbUser=em.find(UserDTO.class, num);
		System.out.println(dbUser);
	}
	public  void deleteProfile(long num)
	{
		UserDTO dbUser=em.find(UserDTO.class, num);
		et.begin();
		em.remove(dbUser);
		et.commit();
		System.out.println("your profile deleted successfully");
	}
	public  void updateProfile(long num)
	{
		System.out.println("1-name 2-mobile 3-gmail 4-password 5-dob 6-address 7-altmobile");
		int enter=sc.nextInt();
		
	}
	public void logOut()
	{
		
	}
	
	
	
	

}
