package com.validations;

import java.util.Random;

public class Otp {
	
    public static int otp() {
        int otpLength = 6; // The length of the OTP
        Random random = new Random();
        int otp=0;

        // Generate random digits and append them to the OTP
        for (int i = 0; i < otpLength; i++) {
        	int digit=random.nextInt(10);
            otp= otp*10+digit;
        }
        return otp;
    }
}

