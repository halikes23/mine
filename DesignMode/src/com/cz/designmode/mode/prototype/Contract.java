package com.cz.designmode.mode.prototype;

public interface Contract extends Cloneable{

	public String print() ;
	
	public Object clone();
	
	public static Integer fileNo = 0 ;
	
}
