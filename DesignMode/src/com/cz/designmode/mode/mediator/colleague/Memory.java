package com.cz.designmode.mode.mediator.colleague;

import java.util.HashMap;
import java.util.Map;

import com.cz.designmode.mode.mediator.Colleague;
import com.cz.designmode.mode.mediator.Mediator;

public class Memory extends Colleague {

	private final static Map<Integer,String> MEMORY = new HashMap<Integer,String>() ;
	
	private Integer lastDataAddr ;
	
	public Memory(Mediator mediator) {
		super(mediator);
	}

	public String getData(Integer hashCode){
		return MEMORY.get(hashCode) ;
	}

	public int writeData(String data){
		lastDataAddr = data.hashCode() ;
		MEMORY.put(lastDataAddr ,data ) ;
		this.getMediator().change(this);
		return lastDataAddr ;
	}

	public Integer getLastDataAddr() {
		return lastDataAddr;
	}

}
