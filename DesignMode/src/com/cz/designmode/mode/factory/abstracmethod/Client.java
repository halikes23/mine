package com.cz.designmode.mode.factory.abstracmethod;

public class Client {

	public static void main(String[] args) {
		
		ExportOperator operator = new Export2TXTOperator();
		operator.export("hello world ! ");
	}
	
}
