package com.itvison.util.Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class Base64Encoder {

	public static void main(String[] args) {
		Base64Encoder theEncoder = new Base64Encoder();
		if (args.length == 0) {
			System.err.println("Bitte eine Zeichenkette zum codieren angeben!");
		}
		System.out.println(args[0] + " --> " + theEncoder.getEncodedString(args[0]));
	}
	
	public String getEncodedString(String toEncode) {
		String theEncoded = "";
		
		MessageDigest sha512;
		try {
			sha512 = MessageDigest.getInstance("SHA-512");
			byte[] encodedBytes = sha512.digest(toEncode.getBytes());
			theEncoded = Base64.encodeBase64String(encodedBytes); 
		} catch (NoSuchAlgorithmException nsae) {
			System.err.println(nsae.getLocalizedMessage());
			nsae.printStackTrace();
		}		
		
		return theEncoded;
	}

}
