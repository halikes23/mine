package com.cz.designmode.mode.observer;

public class Application {

	public static final Subject SUBJECT = new Subject() ;
	
	public static void main(String[] args) {
		
		Observer reader1 = Observer.build() ;
		SUBJECT.register(reader1);
		
		Observer reader2 = Observer.build() ;
		SUBJECT.register(reader2);
		
		System.out.println( "reader1.data : " + reader1.getData() );
		System.out.println( "reader2.data : " + reader2.getData() );
		
		SUBJECT.publish("天要下雨");
		
		System.out.println( "reader1.data : " + reader1.getData() );
		System.out.println( "reader2.data : " + reader2.getData() );
		
		SUBJECT.publish("娘要嫁人");
		
		System.out.println( "reader1.data : " + reader1.getData() );
		System.out.println( "reader2.data : " + reader2.getData() );
	}
	
}
