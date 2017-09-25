package com.cz.designmode.mode.factory.abstracfactory;

import com.cz.designmode.mode.factory.abstracfactory.dicedchicken.DicedChicken;
import com.cz.designmode.mode.factory.abstracfactory.sidedish.SideDish;

public class Client {

	public static void main(String[] args) {
		
		System.out.println( "**********************************************************************************************" );
		System.out.println( "a normal chef " );
		
		KungBaoChickenFactory factory = new DefaultKungBaoChickenFactory() ;
		
		SideDish sideDish = factory.buildSideDish() ;
		DicedChicken dicedChicken = factory.buildChicken() ;
		
		sideDish.process();
		dicedChicken.process();
		
		System.out.println( "**********************************************************************************************" );
		System.out.println( "a freak chef " );
		
		factory = new ShallowFreakKungBaoChickenFactory() ;
		dicedChicken = factory.buildChicken() ;
		sideDish = factory.buildSideDish() ;
		
		dicedChicken.process();
		sideDish.process();
		
		System.out.println( "**********************************************************************************************" );
		System.out.println( "a crazy chef " );
		
		factory = new DeepFreakKungBaoChickenFactory() ;
		dicedChicken = factory.buildChicken() ;
		sideDish = factory.buildSideDish() ;
		
		dicedChicken.process();
		sideDish.process();
		
	}
	
	
}
