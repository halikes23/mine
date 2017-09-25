package com.cz.designmode.mode.builder;

public class Client {

	public static void main(String[] args) {
		
		DataPersistencer director = new DataPersistencer(new TxtDataPersistencerBuilder()) ;
		try {
			director.process("/data/temp/data", "hello world !");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
