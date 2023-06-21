package com.Login;

import java.util.*;
import java.sql.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.validations.LoginValidations;
import com.SignUp.*;

public class ForgotPassword {
	
	Scanner sc=new Scanner(System.in);
	LoginValidations validate=new LoginValidations();
	Login login=new Login();

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("toConnect");
	private static EntityManager em = emf.createEntityManager();
	private static EntityTransaction et = em.getTransaction();

	public void forgotPassword(long num) {
		System.out.println("enter the mobile num");
		long userNum=sc.nextLong();
		UserDTO dbUser = em.find(UserDTO.class, num);
		long dbNum=dbUser.getMobile_num();
		int dbOtp = dbUser.getOtp();
		if (userNum == dbNum) {
			
			boolean notValidOtp = true;
			System.out.println("your otp is:" + dbOtp);
			do {
				System.out.println("enter the otp");
				int userOtp = sc.nextInt();
				if (userOtp == dbOtp) {
					notValidOtp = false;
					System.out.println("enter the new password");
					String usrPass = sc.next();
					boolean isPassValid = validate.validatePassword(usrPass);
					if (isPassValid) {
						boolean notValid = true;
						do {

							System.out.println("confirm your password");
							String cnfrmPass = sc.next();
							if (cnfrmPass.equals(usrPass)) {
								notValid = false;
								System.out.println("password matching");
								dbUser.setPassword(usrPass);
								et.begin();
								em.merge(dbUser);
								et.commit();
								System.out.println("password updated successfully");
								System.out.println("1-for login\n\n2-for logout");
								int enter=sc.nextInt();
								switch(enter)
								{
									case 1:
										login.toLogin();
										break;
									case 2:
										System.out.println("thank you");
								}

							} else {
								System.out.println("password is not matching");
								System.out.println("enter the crct password");
							}
						} while (notValid);
					}
				} else {
					System.out.println("enter the valid otp ");
					System.out.println("the entered otp should be match with given otp");
				}
			} while (notValidOtp);
		} else {
			System.out.println("no user found with this num");
			System.out.println(" 1-enter the crct num\n2- signup");
		}
	}
}
