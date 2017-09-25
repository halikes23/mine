package com.cz.designmode.mode.adapter;

public class LowerStringProcesser implements NewStringProcesser{

	@Override
	public String process(Object str) {
		return str.toString().toLowerCase();
	}

}
