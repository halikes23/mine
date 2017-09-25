package com.cz.thinkinjava.keyfinally;

import java.io.Serializable;

public class DemoFinally implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -3231847353598303149L;

	public static String test1(){
		
		try{
			int i = 1 / 0 ;
			return "Success" + i;
		}catch(Exception e){
			System.out.println("Exception in method");
			return "Exception " ;
		}finally{
			System.out.println("Finally in method");
			return "Finally" ;
		}
		
	}
	
	public static String test2(){
		
		try{
			int i = 1 / 0 ;
			return "Success" + i;
		}catch(Exception e){
			System.out.println("Exception in method");
			return "Exception " ;
		}finally{
			System.out.println("Finally in method");
		}
		
	}
	
	public static String test3(){
		
		try{
			int i = 1 / 0 ;
			return "Success" + i;
		}finally{
			System.out.println("Finally in method");
			return "Finally";
		}
		
	}
	
	public static void main(String[] args) {
		String msg = test1();
		System.out.println("test1 Msg:" + msg);
		System.out.println( );
		
		msg = test2();
		System.out.println("test2 Msg:" + msg);
		System.out.println( );
		
		msg = test3();
		System.out.println("test3 Msg:" + msg);
		System.out.println( );
	}
	
}
