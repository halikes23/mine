package com.cz.designmode.mode.factory.abstracmethod;

public class Export2TXTApi implements ExportApi{

	@Override
	public void export(String data) {
		System.out.println("export 2 txt : " + data);
	}

}
