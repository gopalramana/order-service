package com.brain.software.test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64DecoderAndEncoder {

	public static void main(String[] args) {

		String id="IN#username#password";
		String encoder=encoder(id);
		decoder(encoder);
		
	}
	
	public static String encoder(String normalString ) {
		
		Base64.Encoder encoder = Base64.getEncoder();
		String encodedString = encoder.encodeToString( 
		        normalString.getBytes(StandardCharsets.UTF_8) );
		 
		System.out.println("Encoder :::"+encodedString);
		return encodedString;
		
		
	}
	
	public static String decoder(String encodedString) {
		
		Base64.Decoder decoder = Base64.getDecoder();
		String decoded = new String(decoder.decode(encodedString));
		System.out.println("Decoded :::"+new String(decoded));
 		String[] decode=decoded.split("#");
 		System.out.println(decode[1]);
		
		return decoded;
	}

}
