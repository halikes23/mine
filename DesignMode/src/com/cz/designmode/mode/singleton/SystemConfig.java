package com.cz.designmode.mode.singleton;

public class SystemConfig {

	private static final SystemConfig systemConfig = new SystemConfig() ;
	
	public SystemConfig(){
		
	}
	
	public static SystemConfig getInstance(){
		return systemConfig ;
	}
	
}
