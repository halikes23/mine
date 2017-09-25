package com.cz.designmode.mode.adapter;

public class StringProcesserAdapter implements NewStringProcesser{

	private StringProcesser oldProcesser ;
	
	public StringProcesserAdapter(StringProcesser processer){
		this.oldProcesser = processer ;
	}
	
	@Override
	public String process(Object str) {
		return this.oldProcesser.process(str.toString());
	}

	public StringProcesser getOldProcesser() {
		return oldProcesser;
	}

	public void setOldProcesser(StringProcesser oldProcesser) {
		this.oldProcesser = oldProcesser;
	}

}
