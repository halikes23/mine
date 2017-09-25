package com.cz.designmode.simplefactory;

public class Car implements Vehicle{

	Car(){} ;
	
	@Override
	public void run(String target) {
		System.out.println( "run to " + target + " by four wheel" );
	}

	
	
}
