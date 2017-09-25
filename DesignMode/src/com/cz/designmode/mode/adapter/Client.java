package com.cz.designmode.mode.adapter;

public class Client {

	public static void main(String[] args) {
		
		StringProcesser oldStringProcesser = new UpperStringProcesser() ;
		
		StringProcesserAdapter adapter = new StringProcesserAdapter(oldStringProcesser) ;
		String str = adapter.process("lower") ;

		System.out.println(str); ;
		
	}
	
}
