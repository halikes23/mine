package com.cz.designmode.mode.proxy;

import java.util.HashMap;
import java.util.Map;

public class AccountProxy implements Account{
	
	private static final Map<String,Account> cache = new HashMap<String,Account>() ;
	
	private boolean isLoaded = false;
	
	private Account account ;

	public AccountProxy(Account account){
		this.account = account;
	}
	
	@Override
	public String getAccount() {
		return account.getAccount();
	}

	public void setHead(String head){
		
		if(head.equals(account.getHead())){
			this.account.setHead(head);
			cache.put(this.getAccount(), account) ;
		}else{
			this.account.setHead(head);
		}
		
		
	
	}
	
	@Override
	public String getHead() {
		if( isLoaded == false ){
			// account.setHead(reloadHead(account.getAccount()) ;  ;
			isLoaded = true ;
			return "http://upyun.jnwtv.com/"+account.getHead();
			
		}else{
			return null ;
		}
		
	}

	@Override
	public void setAccount(String a) {
		this.account.setAccount(a);
	}

}
