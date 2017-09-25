package com.cz.thinkinjava.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class DemoReflect {

	public DemoReflect(String arg){
		System.out.println("init method " + arg);
	}
	
	public void test(){
		System.out.println("test");
	}
	
	
	public void test(String arg){
		System.out.println("test " + arg);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, Exception, SecurityException {
		
		Class<?> clazz = Class.forName(args[0]) ;
//		Class<?> clazz = DemoReflect.class ;

		try{
		
			Constructor<?> constructor = clazz.getConstructor() ;
			constructor.newInstance() ;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Constructor<?> constructor = clazz.getConstructor(String.class) ;
		Object obj = constructor.newInstance("arg1") ;
		
		Method test = clazz.getMethod("test") ;
		test.invoke(obj) ;
		
		test = clazz.getMethod("test",String.class) ;
		test.invoke(obj,"2") ;
		
	}
	
}
