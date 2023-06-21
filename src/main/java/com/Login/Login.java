package com.Login;
import com.SignUp.*;
import com.validations.*;
import com.profiles.UserProfile;
import java.sql.*;
import java.util.*;

public class Login {
	
	static Scanner sc=new Scanner(System.in);
	static LoginValidations valid=new LoginValidations();
	ToSignUp signup=new ToSignUp();
	UserProfile userProfile=new UserProfile();
	ForgotPassword forgot=new ForgotPassword();

	public  void mobile(String s)
	{
		boolean b=true;
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			if(ch>=48&&ch<=57)
			{
				b=true;
			}
			else
			{
				b=false;
			}
		}
		if(b)
		{
			long num=Long.parseLong(s);
			boolean isMobileValid=valid.validateMobile_Num(num);
			if(isMobileValid)
			{
				
				if(Check.isMobileThere(num))
				{
					System.out.println("enter your password");
					String password=sc.next();
					boolean isPasswordValid=valid.validatePassword(password);
					if(isPasswordValid)
					{
						if(Check.isPasswordThere(password,num))
						{
							System.out.println("login successfull");
							userProfile.showUserData(num);
						}
						else
						{
							System.out.println("incorrect password");
							System.out.println(" enter 1-forgot password\n2-logout");
							int enter=sc.nextInt();
							switch(enter)
							{
								case 1:
									forgot.forgotPassword(num);
									break;
								case 2:
									System.out.println("thankyou");
									break;
							}
							
						}
					}
					
				}
				else
				{
					System.out.println("user not found");
					System.out.println("dont have account then create one");
					System.out.println("1-to signup\n2-logout");
					int enter=sc.nextInt();
					switch(enter)
					{
						case 1:
							signup.toSignUp();
							break;
						case 2:
							System.out.println("thankyou");
							break;
					}
					
				}
			}
		}
		else
		{
			boolean isGmailValid=valid.validateGmail(s);
		}
	}
	public void toLogin()
	{
		System.out.println("1--mobileNum\n\n0--dont have account then create one");
		int enter=sc.nextInt();
		switch(enter)
		{
			case 1:
				System.out.println("enter the mobilenum");
				String userId=sc.next();
				mobile(userId);
				break;
			case 0:
				System.out.println("dont have account then create one");
				signup.toSignUp();
		}
	}
	
	

}
