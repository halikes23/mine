package com.cz.thinkinjava.demo;

public class RealBird implements Bird{

	@Override
	public void cry(Cry cry) {
		cry.cry(); 
	}

	@Override
	public void fly(Fly fly) {
		fly.fly(); 
	}

	
	
}
