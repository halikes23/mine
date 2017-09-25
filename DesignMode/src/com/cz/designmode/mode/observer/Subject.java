package com.cz.designmode.mode.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

	private List<Observer> readers = new ArrayList<Observer>() ;

	public void register(Observer reader){
		readers.add(reader) ;
	}
	
	public void publish(String data){
		
		System.out.println( "Subject publish new data : " + data );
		
		for(Observer reader : readers){
			reader.update(data);
		}
	}
	
}
