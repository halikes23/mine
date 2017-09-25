package com.cz.designmode.mode.factory.abstracmethod;

public class Export2DBOperator extends ExportOperator{

	@Override
	protected ExportApi buildOperator() {
		return new Export2DBApi();
	}

	
	
}
