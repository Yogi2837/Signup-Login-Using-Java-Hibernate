package com.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
public class ValidateUpdatingDetails {
	
	Scanner sc=new Scanner(System.in);
	public  boolean validateName(String name)
	{      
		if(name.length()>=3)
		{
			String pattern = "^[a-zA-Z]+$";
			Pattern regex = Pattern.compile(pattern);
	        Matcher match = regex.matcher(name);
	        if (match.matches()) {
	            return true;
	        } 
	        else {
	            System.out.println("The name should contain only alphabets");
	            System.out.println("enter the valid name");
	            String vName=sc.nextLine();
	            validateName(vName);
	        }
	        //alternative way to validate the name
//	        String emp="";
//	        for(int i=0;i<name.length();i++)
//	        {
//	        	char ch=name.charAt(i);
//	        	if((!(ch>=48&&ch<=57))&&(ch>=65&&ch<=90||ch>=97&&ch<=122))
//	        	{
//	        		emp=emp+ch;
//	        	}
//	        }
//	        if(name.equals(emp))
//	        {
//	        	store.setName(name);
//	        }
//	        else
//	        {
//	        	 System.out.println("The name should contain only alphabets");
//		         System.out.println("enter the valid name");
//		         String vName=sc.nextLine();
//		         validateName(vName);
//	        }
		}
		else
		{
			System.out.println("the name should be atleast three letters ");
			System.out.println("enter the valid name");
			String vName=sc.nextLine();
			validateName(vName);
		}
		return false;
	}
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
		if(symbl>=1&&upper>=1&&lower>=1&&num>=1&&psswd.length()==8)
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
	public  boolean validateAge(int age)
	{
		if(age>=18&&age<=60)
		{
			return true;
		}
		else
		{
			System.out.println("age should be between 18 to 60");
			System.out.println("enter the valid details");
			int vAge=sc.nextInt();
			validateAge(vAge);
		}
		return false;
	}
	public boolean validateDob(String dob)
	{
		String dmy[]=dob.split("/");
		try
		{
			int date=Integer.parseInt(dmy[0]);
			int month=Integer.parseInt(dmy[1]);
			int year=Integer.parseInt(dmy[2]);
			boolean d=(date>=1&&date<=31)?true:false;
			boolean m=(month>=1&&month<=12)?true:false;
			boolean y=(year>=1980&year<=2006)?true:false;
			if(d&&m&&y)
			{
				return true;
			}
			else
			{
				System.out.println("please enter valid date details");
			}
		}
		catch (NumberFormatException e) 
		{
			System.out.println("the dob should not contain any characters only nums\nEnter the valid date ");
			String vdob=sc.next();
			validateDob(vdob);
		}
		return false;
		
	}
	public  boolean validateAltMobile_Num(long altNum,long num)
	{
		 
		 String s=num+"";
		 if((s.charAt(0)=='9'||s.charAt(0)=='8'||s.charAt(0)=='7'
				 ||s.charAt(0)=='6')&&s.length()==10)
		 {
			 if(altNum==num)
			 {
				 System.out.println("the altnum and mobile num should not be same\nPlease enter the another mobile num");
				 long atlNum=sc.nextLong();
				 validateAltMobile_Num(atlNum,num);
			 }
			 else
			 {
				 return true;
			 }
		 }
		 else
		 {
			 System.out.println("enter the valid phone num.. The num should start from 9 or 8 or 7 or 6");
			 System.out.println("enter the valid num");
			 long vNum=sc.nextLong();
			 validateAltMobile_Num(vNum,num);
		 }
		return false;
	}
//	public  void validateAltGmail(String gmail)
//	{
//		String s="@gmail.com";
//		int count=0;
//		for(int i=0;i<gmail.length();i++)
//		{
//			if(gmail.charAt(i)=='@')
//			{
//				count++;
//			}
//		}
//		if(count==1&&gmail.startsWith(s)==false&&gmail.endsWith(s)==true)
//		{
//			//if(gmail.equals(store.getGmail()))
//			{
//				System.out.println("the altgmail and gmail should not be same\nPlease enter the another gmail");
//				String atlGma=sc.next();
//				validateAltGmail(atlGma);
//			}
//			//else
//			{
//				//store.setAltGmail(gmail);
//			}
//		}
//		else
//		{
//			System.out.println("please enter the valid gmail address");
//			String vgm=sc.next();
//			validateAltGmail(vgm);
//		}

}
