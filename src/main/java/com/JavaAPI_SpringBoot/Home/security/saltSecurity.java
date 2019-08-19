package com.JavaAPI_SpringBoot.Home.security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Used by {@link ExceptionTranslationFilter} to commence an authentication scheme.
 * @author Tushar Malakar
 */

/**
SHA-128 = 128 bits = SHA-1
SHA-256 = 256 bits = SHA-2
SHA-512 = 512 bits = SHA-3
**/

public class saltSecurity {

	public static StringBuilder encrypt(String password) {
		try {
			
			/**
			 * The MessageDigest class provides the functionality of 
			 * a message digest algorithm, we will be getting the 
			 * MessageDigest instance by passing the algorithm to 
			 * the getInstance() method. */
			
			//select the message digest for the hash computation -> SHA-256
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			
			/**
			 * As per OWASP, Salt should be generated using a Cryptographically 
			 * Secure Pseudo-Random Number Generator (CSPRNG), for Java the CSPRNG  
			 * is java.security.SecureRandom. We will be creating a new instance for 
			 * SecureRandom class and the nextByte() method generates the random salt*/
			
			//Generate the RANDOM Salt
			//each byte is one hex word
			byte[] salt = new byte[16];
			SecureRandom  random = new SecureRandom();
			random.nextBytes(salt);
			
			//passing the salt to ditgest for the computation
			//We will be adding the salt to input using the update() method of MessageDigest
			md.update(salt);
			
			//generate the salted hash
			byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
			StringBuilder strBuilder = new StringBuilder();
			for (byte b : hashedPassword)
				strBuilder.append(String.format("%02x", b));
				return strBuilder;
		//end-of try block
		} catch (NoSuchAlgorithmException e){
			
			//Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[16];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
	
	
//	public static void main(String[] args){
//		String password = "mySaltPassword";
//		StringBuilder strBuilder = saltSecurity.encrypt(password);
//		System.out.println(strBuilder);
//	}
}
