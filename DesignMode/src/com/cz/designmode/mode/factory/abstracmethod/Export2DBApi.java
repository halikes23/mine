package com.cz.designmode.mode.factory.abstracmethod;

public class Export2DBApi implements ExportApi{

	@Override
	public void export(String data) {
		System.out.println("export 2 db : " + data);
	}

}
