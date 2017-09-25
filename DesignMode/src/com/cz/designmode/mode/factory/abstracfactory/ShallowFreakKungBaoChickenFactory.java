package com.cz.designmode.mode.factory.abstracfactory;

import com.cz.designmode.mode.factory.abstracfactory.dicedchicken.DefaultDicedChicken;
import com.cz.designmode.mode.factory.abstracfactory.dicedchicken.DicedChicken;
import com.cz.designmode.mode.factory.abstracfactory.sidedish.FreakSideDish;
import com.cz.designmode.mode.factory.abstracfactory.sidedish.SideDish;

public class ShallowFreakKungBaoChickenFactory implements KungBaoChickenFactory{

	@Override
	public DicedChicken buildChicken() {
		return new DefaultDicedChicken() ;
	}

	@Override
	public SideDish buildSideDish() {
		return new FreakSideDish();
	}

}
