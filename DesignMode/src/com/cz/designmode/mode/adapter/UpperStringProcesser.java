package com.cz.designmode.mode.adapter;

public class UpperStringProcesser implements StringProcesser {

	@Override
	public String process(String str) {
		return str.toUpperCase();
	}

}
