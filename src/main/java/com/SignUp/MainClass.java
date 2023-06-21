package com.SignUp;

import java.util.Scanner;

import com.Login.Login;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		ToSignUp signup=new ToSignUp();
		Login login=new Login();
		System.out.println("choose what you want\n1-Signup\n\n2-login");
		int enter=sc.nextInt();
		switch(enter)
		{
			case 1:
				signup.toSignUp();
				break;
			case 2:
				login.toLogin();	
		}	
		sc.close();

	}

}
