package com.cz.designmode.mode.facade;

public class DefaultProcesser implements Processer{

	@Override
	public void process() {
		System.out.println("default process execute ");
	}

}
