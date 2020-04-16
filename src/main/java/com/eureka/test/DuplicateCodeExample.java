package com.eureka.test;

import java.security.SecureRandom;

public class DuplicateCodeExample {
	
	public static int generateOTP() {
		SecureRandom random=new SecureRandom();
		return random.nextInt(999)+1000;
	}
	
	public static int  generateStringOTP() {
		SecureRandom random=new SecureRandom();
		return random.nextInt(999)+1000;
	}

}
