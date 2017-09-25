package com.cz.designmode.mode.singleton;

public class Client {

	public static void main(String[] args) {
		
		System.out.println( new SystemConfig().hashCode());
		System.out.println( new SystemConfig().hashCode());
		System.out.println( SystemConfig.getInstance().hashCode());
		System.out.println( SystemConfig.getInstance().hashCode());
		
	}
	
}
