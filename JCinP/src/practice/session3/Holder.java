package practice.session3;

import java.util.concurrent.atomic.AtomicReference;

import practice.session2.Test;

public class Holder {

	private int n ;
	
	private Holder(int n){
		this.n = n ;
	}
	
	public void assertSanity(){
		if(n!=n)
			throw new AssertionError() ;
	}
	
}
