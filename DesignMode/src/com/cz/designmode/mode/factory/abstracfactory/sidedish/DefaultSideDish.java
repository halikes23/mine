package com.cz.designmode.mode.factory.abstracfactory.sidedish;

public class DefaultSideDish implements SideDish {

	@Override
	public void process() {
		
		System.out.println("push some peanuts ");
		System.out.println("push some pimientos  ");
		System.out.println("fired ...");
		
	}

}
