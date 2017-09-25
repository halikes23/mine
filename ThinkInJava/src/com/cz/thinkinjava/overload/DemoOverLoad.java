package com.cz.thinkinjava.overload;

public class DemoOverLoad {

	public Integer test(Integer a , Integer b){
		System.out.println("public Integer test(Integer a , Integer b) ");
		return a + b ;
	}
	
	public Integer test(Integer a , String b){
		System.out.println("public Integer test(Integer a , String b) ");
		return a + Integer.parseInt(b) ;
	}
	
	public Integer test(Integer a , Integer b , Integer c){
		test(a,b ,new Integer[]{c});
		System.out.println("public Integer test(Integer a , Integer b , Integer c) ");
		return a + b + c ;
	}
	
	public Integer test(Integer a , Integer b , Integer ... cs){
		System.out.println("public Integer test(Integer a , Integer b , Integer ... cs) ");
		int temp = a + b ;
		for(Integer c : cs ){
			temp += c ;
		}
		return temp ;
	}
	
	public Integer test(Integer a , Integer b , Object ... cs){
		System.out.println("public Integer test(Integer a , Integer b , Object ... cs) ");
		int temp = a + b ;
		for(Object c : cs ){
			temp += (Integer)c ;
		}
		return temp ;
	}
	
	public static void main(String[] args) {
		DemoOverLoad dol = new DemoOverLoad() ;
		Object o = 4 ;
		dol.test(1,2) ;
		dol.test(1, "2") ;
		dol.test(1, 2, 3) ;
		dol.test(1, 2, 3 , 4) ;
		dol.test(1, 2, o ,o) ;
	}
	
}
