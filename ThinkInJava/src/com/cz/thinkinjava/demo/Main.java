package com.cz.thinkinjava.demo;

public class Main {

	public static void main(String[] args) {
		Bird cock = new RealBird() ;
		cock.fly(new DefaultFly());
		cock.cry(new CockCry());
	}
	
}
