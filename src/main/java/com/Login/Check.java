package com.Login;
import java.sql.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.SignUp.UserDTO;

public class Check {
	
	private static EntityManagerFactory emf=Persistence.createEntityManagerFactory("toConnect");
	private static EntityManager em=emf.createEntityManager();
	private static EntityTransaction et=em.getTransaction();
	
	
	public static boolean isMobileThere(long num)
	{
		UserDTO dbUser=em.find(UserDTO.class, num);
		if(dbUser.getMobile_num()==num)
		{
			return true;
		}
	return false;
	}
	
	public static boolean isGmailThere(String gmail,long num)
	{
		UserDTO dbUser=em.find(UserDTO.class, num);
		if(dbUser.getGmail().equals(gmail))
		{
			return true;
		}
	return false;
	}
	
	public static boolean isPasswordThere(String password,long num)
	{
		UserDTO dbUser=em.find(UserDTO.class, num);
		if(dbUser.getPassword().equals(password))
		{
			return true;
		}
	return false;	
	}

}
