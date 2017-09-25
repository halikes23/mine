package com.cz.thinkinjava.shortout;

/**
 * 短路Demo
 * @author cz
 *
 */
public class DemoShortOut {

	private static boolean test( int value ){ 
		System.out.println("test is invoked");
		return value > 1 ;
	}
	
	
	public static void main(String[] args){
		System.out.println("a = 2 ,b = 0 ");
		int a = 2 ;
		int b = 0 ;
		// test(a) 为true 概率较高用这个
		System.out.println("test(a)||test(b):"+ ( test(a) || test(b) ) );
		// test(a) 为false 概率较高用这个
		System.out.println("!(test(a)&&test(b)):"+!(test(a) && test(b)));
		
		System.out.println("\na = 0 ,b = 2 ");
		
		a = 0 ;
		b = 2 ;
		// test(a) 为true 概率较高用这个
		System.out.println("test(a)||test(b):"+ ( test(a) || test(b) ) );
		// test(a) 为false 概率较高用这个
		System.out.println("!(test(a)&&test(b))"+!(test(a) && test(b)));

	}

	
}
