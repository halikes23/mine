package com.cz.designmode.mode.factory.abstracfactory.dicedchicken;

public class DefaultDicedChicken implements DicedChicken {

	@Override
	public void process() {
		
		System.out.println( "add some diced chicken" );
		System.out.println("fried ... ");
		
	}

}
