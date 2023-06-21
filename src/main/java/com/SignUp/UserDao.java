package com.SignUp;

import java.sql.*;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserDao {

	static Scanner sc = new Scanner(System.in);
	
	
	private static EntityManagerFactory emf=Persistence.createEntityManagerFactory("toConnect");
	private static EntityManager em=emf.createEntityManager();
	private static EntityTransaction et=em.getTransaction();
	
	public void insert(UserDTO user) {
		
		user.setName(user.getName());
		user.setMobile_num(user.getMobile_num());
		user.setGmail(user.getGmail());
		user.setAge(user.getAge());
		user.setPassword(user.getPassword());
		user.setGender(user.getGender());
		user.setDob(user.getDob());
		user.setAddress(user.getAddress());
		user.setAltMobile_num(user.getAltMobile_num());
		et.begin();
		em.persist(user);
		et.commit();
	}

	public void read(long num) {
		
		UserDTO dbUser=em.find(UserDTO.class, num);
		System.out.println(dbUser);
	}

	public void update(long num) {

	}

	public void delete(long num) {
		UserDTO dbUser=em.find(UserDTO.class, num);
		et.begin();
		em.remove(dbUser);
		et.commit();
		System.out.println("your profile deleted successfully");
	}
}
