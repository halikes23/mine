package com.cz.designmode.mode.factory.abstracmethod;

public abstract class ExportOperator {

	public void export(String data){
		this.buildOperator().export(data);
	}
	
	protected abstract ExportApi buildOperator() ;
	
}
