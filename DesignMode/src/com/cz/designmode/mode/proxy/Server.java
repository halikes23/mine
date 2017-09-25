package com.cz.designmode.mode.proxy;

import java.util.ArrayList;
import java.util.List;

public class Server {

	private List<AccountImpl> accounts = new ArrayList<AccountImpl>() ;
	
	public Server(){
		
		AccountImpl account1 = new AccountImpl();
		account1.setAccount("ac1");
		account1.setHead("999d0c95-8f40-4131-bd87-63d86e23a7fb");
		AccountImpl account2 = new AccountImpl();
		account2.setAccount("ac2");
		account2.setHead("H18321068683148766474905486937787.jpg");
		
		accounts.add(account1) ;
		accounts.add(account2) ;
		
	}

//	public List<Account> searchAllSimpleAccounts(){
//		
//		return accounts ;
//		
//	}  
	
//	public List<Account> searchAllAccounts(){
//		
//		List<Account> accountProxys = new ArrayList<Account>() ;
//		for( Account account : accounts ){
//			Account accountProxy = new AccountProxy(account) ;
//			accountProxys.add(accountProxy) ;
//		}
//		
//		return accountProxys ;
//		
//	}  
	
	public List<AccountImpl> searchAllAccounts2(){
		
		List<AccountImpl> accountProxys = new ArrayList<AccountImpl>() ;
		for( AccountImpl account : accounts ){
			AccountDynamicProxy accountProxy = new AccountDynamicProxy(account) ;
			AccountImpl a = accountProxy.getProxyInterface() ;
			accountProxys.add(a) ;
		}
		
		return accountProxys ;
		
	}
	
}
