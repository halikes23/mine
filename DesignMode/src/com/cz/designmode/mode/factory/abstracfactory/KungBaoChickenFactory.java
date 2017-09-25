package com.cz.designmode.mode.factory.abstracfactory;

import com.cz.designmode.mode.factory.abstracfactory.dicedchicken.DicedChicken;
import com.cz.designmode.mode.factory.abstracfactory.sidedish.SideDish;

public interface KungBaoChickenFactory {

	public DicedChicken buildChicken() ;
	
	public SideDish buildSideDish() ;
	
}
