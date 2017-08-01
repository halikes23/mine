package com.cz.tool;

import java.util.Random;

public class RandomStringBuilder {
	
	private static final Random random = new Random();
	
	public static void main(String[] args) {
		int length ;
		if(args.length == 1){
			length = Integer.parseInt(args[0]) ;
		}else{
			length = 32 ;
		}
		
		String randomString = random(length);
		
		System.out.println(randomString);
		
	}
	
	public static String random(Integer length){
		
		StringBuilder rst = new StringBuilder();
		
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_+*/;:~!@#$%^&*()" ;
		
		String[] codes = str.split("") ;
		
		Integer codesLength = codes.length ;
		
		
		
		for(int i = 0 ; i < length ; i ++){
			int index = random.nextInt(codesLength) ;
			rst.append(codes[index]) ;
		}
		
		return rst.toString() ;
		
	}
	
}
