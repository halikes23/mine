package com.cz.designmode.mode.factory.abstracmethod;

public class Export2TXTOperator extends ExportOperator{

	@Override
	protected ExportApi buildOperator() {
		return new Export2TXTApi();
	}

}
