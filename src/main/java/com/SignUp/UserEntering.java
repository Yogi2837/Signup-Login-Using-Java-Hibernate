package com.SignUp;

import com.validations.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class UserEntering {
	
	static Scanner sc=new Scanner(System.in);
	private UserDTO store;
	private ToValidate validate;
	private ConcurrentHashMap<Integer, String> details;
	private UserDao userDao;
	
	public UserEntering(ConcurrentHashMap<Integer, String> details,ToValidate validate,UserDTO store,UserDao userDao)
	{
		this.details=details;
		this.validate=validate;
		this.store=store;
		this.userDao=userDao;
	}
	public  void toEnterDetails(int take)
	{
		for(Integer i:details.keySet())
		{
			if(i==take)
			{
				details.remove(i);
			}
			if (details.get(i)!=null) {
				
				System.out.print(i+"--"+details.get(i)+"  ");
			}
			if(i%3==0)
			{
				System.out.println();
			}
		}
	}
	public  void inputMismatch()
	{
		try
		{
			
			sc.nextLine();
			long ph=sc.nextLong();
			validate.validateMobile_Num(ph);
		}
		catch(InputMismatchException e1)
		{
			System.out.println("enter only nums");
			inputMismatch();
		}
		
	}
	public  void inputMismatch(int age)
	{
		try
		{
			
			sc.nextLine();
			int vAge=sc.nextInt();
			validate.validateAge(vAge);
		}
		catch(InputMismatchException e1)
		{
			System.out.println("enter only nums");
			inputMismatch(0);
		}
	}
	
	public  void showWhatToEnter() {
		
		//sc.nextLine();
		System.out.println("enter the num which details you want to enter");
		int enter=sc.nextInt();
		switch(enter)
		{
			case 1:
				System.out.println("enter your name");
				String name=sc.next();
				validate.validateName(name);
				//System.out.println(store.getName());
				toEnterDetails(enter);
				showWhatToEnter();
				break;
			case 2:
				try
				{
					System.out.println("enter your mobileNum");
					long phno=sc.nextLong();
					validate.validateMobile_Num(phno);
				}
				catch(InputMismatchException e)
				{
					System.out.println("you should enter only nums");
					inputMismatch();
				}
				toEnterDetails(enter);
				showWhatToEnter();
				break;
			case 3:
				System.out.println("enter your Gmail");
				String gmail=sc.next();
				validate.validateGmail(gmail);
				toEnterDetails(enter);
				showWhatToEnter();
				break;
			case 4:
				System.out.println("enter your Password");
				String pswd=sc.next();
				validate.validatePassword(pswd);
				toEnterDetails(enter);
				showWhatToEnter();
				break;
			case 5:
				try
				{
					System.out.println("enter your Age");
					int age=sc.nextInt();
					validate.validateAge(age);
				}
				catch(InputMismatchException e)
				{
					System.out.println("you should enter only nums");
					inputMismatch(0);
				}
				toEnterDetails(enter);
				showWhatToEnter();
				break;
			case 6:
				System.out.println("choose your gender\nEnter 1 for male\nEnter 2 for female\nEnter 3 for others");
				int chooseGen=sc.nextInt();
				switch (chooseGen) {
				case 1:
					System.out.println("male");
					String gen="male";
					store.setGender(gen);
					break;
				case 2:
					System.out.println("female");
					String gen2="female";
					store.setGender(gen2);
					break;
				case 3:
					System.out.println("others");
					String gen3="others";
					store.setGender(gen3);
					break;
				}
				toEnterDetails(enter);
				showWhatToEnter();
				break;
			case 7:
				System.out.println("enter your Dob\nThe format is dd/mm/yyyy");
				String dob=sc.next();
				validate.validateDob(dob);
				toEnterDetails(enter);
				showWhatToEnter();
				break;
			case 8:
				System.out.println("enter your address");
				String address=sc.next();
				store.setAddress(address);
				toEnterDetails(enter);
				showWhatToEnter();
				break;
			case 9:
				try
				{
					System.out.println("enter your altMobileNum");
					long atlNum=sc.nextLong();
					validate.validateAltMobile_Num(atlNum);
				}
				catch(InputMismatchException e)
				{
					System.out.println("you should enter only nums");
					inputMismatch();
				}
				toEnterDetails(enter);
				showWhatToEnter();
				break;
			case 10:
				System.out.println("enter your atlGmail");
				String atlgmail=sc.next();
				validate.validateAltGmail(atlgmail);
				toEnterDetails(enter);
				showWhatToEnter();
				break;
			case 0:
				userDao.insert(store);
				System.out.println("submited");
		}
		
	}

}
