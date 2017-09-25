package com.cz.designmode.mode.observer;

public class Observer {

	private String data = "No data";
	
	private Observer(){} 
	
	public static Observer build(){
		Observer reader = new Observer() ;
		Application.SUBJECT.register(reader);
		return reader ;
	}
	
	public void update(String data){
		System.out.println( "data is updated : " + data );
		this.data = data ;
	}

	public String getData() {
		return data;
	}
	
}
