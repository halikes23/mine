package com.cz.designmode.mode.facade;

public class Executor {
	
	public void execute(){
		
		Beginer beginer = new DefaultBeginer() ;
		beginer.begin(); 
		
		Processer processer = new DefaultProcesser() ;
		processer.process(); 
		
		Ender ender = new DefaultEnder() ;
		ender.end(); 
	}
	
}
