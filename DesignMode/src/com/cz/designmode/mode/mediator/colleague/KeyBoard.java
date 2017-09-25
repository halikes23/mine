package com.cz.designmode.mode.mediator.colleague;

import com.cz.designmode.mode.mediator.Colleague;
import com.cz.designmode.mode.mediator.Mediator;

public class KeyBoard extends Colleague{

	private String data ;
	
	public KeyBoard(Mediator mediator) {
		super(mediator);
	}
	
	public void input(String data){
		this.data = data ;
		this.getMediator().change(this);
	}

	public String getData() {
		return data;
	}


}
