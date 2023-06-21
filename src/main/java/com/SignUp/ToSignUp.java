package com.SignUp;

import java.util.concurrent.ConcurrentHashMap;
import com.validations.*;
public class ToSignUp {

	public  void toSignUp() {
		// TODO Auto-generated method stub
		System.out.println("1--Name(*) 2--Mobile num(*) 3--Gmail(*)\n4--Password(*) 5--Age 6--Gender\n7--Date of birth 8--Address 9--Alternative mobile num 10--Alternative Gmail\n0--submit");
		ConcurrentHashMap<Integer,String> details=new ConcurrentHashMap<>();
		details.put(1, "Name");
		details.put(2, "Mobile_Num");
		details.put(3, "Gmail");
		details.put(4, "Password");
		details.put(5, "Age");
		details.put(6, "Gender");
		details.put(7, "Date of birth");
		details.put(8, "Address");
		details.put(9, "alternative mobile num");
		details.put(10, "alternative gmail");
		details.put(0, "Submit ");
		
		UserDTO store =new UserDTO();
		UserDao userDao= new UserDao();
		UserEntering userdata=new UserEntering(details,new ValidateDetails(store),store,userDao);
		userdata.showWhatToEnter();
		
	}

}
