package com.validations;
import com.Login.*;
import java.util.*;
public class LoginValidations{
	
	Scanner sc=new Scanner(System.in);
	
	public  boolean validateMobile_Num(long num)
	{
		 
		 String s=num+"";
		 if((s.charAt(0)=='9'||s.charAt(0)=='8'||s.charAt(0)=='7'
				 ||s.charAt(0)=='6')&&s.length()==10)
		 {
			 return true;
		 }
		 else
		 {
			 System.out.println("enter the valid phone num.. The num should start from 9 or 8 or 7 or 6");
			 System.out.println("enter the valid num");
			 long vNum=sc.nextLong();
			 validateMobile_Num(vNum);
		 }
		 return false;
	}
	public  boolean validateGmail(String gmail)
	{
		String s="@gmail.com";
		int count=0;
		for(int i=0;i<gmail.length();i++)
		{
			if(gmail.charAt(i)=='@')
			{
				count++;
			}
		}
		if(count==1&&gmail.startsWith(s)==false&&gmail.endsWith(s)==true)
		{
			return true;
		}
		else
		{
			System.out.println("please enter the valid gmail address");
			String vgm=sc.next();
			validateGmail(vgm);
		}
		return false;
		
	}
	public boolean validatePassword(String psswd)
	{
		
		int symbl=0,upper=0,lower=0,num=0;
		for(int i=0;i<psswd.length();i++)
		{
			char ch=psswd.charAt(i);
			if(ch>=97&&ch<=122)
			{
				lower++;
			}
			if(ch>=65&&ch<=90)
			{
				upper++;
			}
			if(ch>=48&&ch<=57)
			{
				num++;
			}
			else
			{
				symbl++;
			}
		}
		if(symbl>=1&&upper>=1&&lower>=1&&num>=1&&psswd.length()>=8)
		{
			return true;
		}
		else
		{
			System.out.println("the password should contain"
					+ " atleast 1 special char 1 Uppercase 1 lowercase 1 digit and password length should be 8");
			System.out.println("enter the valid password");
			String vPswd=sc.next();
			validatePassword(vPswd);
		}
	return false;
		
	}

	
}
