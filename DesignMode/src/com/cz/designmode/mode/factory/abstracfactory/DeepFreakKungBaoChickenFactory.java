package com.cz.designmode.mode.factory.abstracfactory;

import com.cz.designmode.mode.factory.abstracfactory.dicedchicken.DicedChicken;
import com.cz.designmode.mode.factory.abstracfactory.dicedchicken.FreakDicedChicken;
import com.cz.designmode.mode.factory.abstracfactory.sidedish.FreakSideDish;
import com.cz.designmode.mode.factory.abstracfactory.sidedish.SideDish;

public class DeepFreakKungBaoChickenFactory implements KungBaoChickenFactory{

	@Override
	public DicedChicken buildChicken() {
		return new FreakDicedChicken();
	}

	@Override
	public SideDish buildSideDish() {
		return new FreakSideDish();
	}

}
