package com.cz.designmode.mode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AccountDynamicProxy implements InvocationHandler {

	private AccountImpl account ;
	
	public AccountDynamicProxy(AccountImpl account){
		this.account = account ;
	}
	
	public AccountImpl getProxyInterface(){
		AccountImpl proxy = (AccountImpl)Proxy.newProxyInstance(account.getClass().getClassLoader(), account.getClass().getInterfaces(), this ) ;
		return proxy;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if( method.getName().equals("getHead") ){
			return "http://upyun.jnwtv.com/"+ method.invoke(account) ;
		}else{
			return method.invoke(account, args) ;
		}
	}
	
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		AccountImpl account = new AccountImpl() ;
		account.setHead("123");
		account.setAccount("345");
		Object obj = new AccountDynamicProxy(account) ;
		
		Method method = AccountDynamicProxy.class.getMethod("getAccount") ;
		Account a = (Account)method.invoke(obj) ;
		
		System.out.println(a.getAccount());
		
	}

	public AccountImpl getAccount() {
		return account;
	}

	
	
}
