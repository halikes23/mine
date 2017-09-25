package com.cz.designmode.mode.factory.abstracfactory;

import com.cz.designmode.mode.factory.abstracfactory.dicedchicken.DefaultDicedChicken;
import com.cz.designmode.mode.factory.abstracfactory.dicedchicken.DicedChicken;
import com.cz.designmode.mode.factory.abstracfactory.sidedish.DefaultSideDish;
import com.cz.designmode.mode.factory.abstracfactory.sidedish.SideDish;

public class DefaultKungBaoChickenFactory implements KungBaoChickenFactory{

	@Override
	public DicedChicken buildChicken() {
		return new DefaultDicedChicken();
	}

	@Override
	public SideDish buildSideDish() {
		return new DefaultSideDish();
	}

	
	
}
