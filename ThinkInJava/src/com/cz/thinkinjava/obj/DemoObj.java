package com.cz.thinkinjava.obj;

public class DemoObj {

	
	String value ;
	
	public static void test(DemoObj demoObj){
		demoObj = new DemoObj() ;
		demoObj.setValue("newValue");
	}
	
	public static void test2(DemoObj demoObj){
		demoObj.setValue("newValue");
	}
	
	public static void main(String[] args) {
		
		DemoObj demoObj = new DemoObj() ;
		demoObj.setValue("oldValue");
		
		test(demoObj) ;
		
		System.out.println(demoObj.getValue());
		
		test2(demoObj) ;
		
		System.out.println(demoObj.getValue());
	}


	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
