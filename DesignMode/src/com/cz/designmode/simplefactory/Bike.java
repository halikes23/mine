package com.cz.designmode.simplefactory;

public class Bike implements Vehicle{

	@Override
	public void run(String target) {
		System.out.println( "run to " + target + " by two wheel" );
	}

}
