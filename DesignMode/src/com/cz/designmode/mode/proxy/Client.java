package com.cz.designmode.mode.proxy;

import java.util.List;

public class Client {
	
	public static void main(String[] args) {
		
		Server server = new Server() ;
		
		List<AccountImpl> accounts ; // = server.searchAllAccounts() ;
		
//		for(Account account : accounts){
//			System.out.println( "account：" + account.getAccount() + " head:" + account.getHead() );
//		}
		
		accounts = server.searchAllAccounts2() ;
		for(AccountImpl account : accounts){
			System.out.println( "account：" + account.getAccount() + " head:" + account.getHead() );
		}
	}
	
}
