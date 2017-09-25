package com.cz.designmode.mode.mediator.colleague;

import com.cz.designmode.mode.mediator.Colleague;
import com.cz.designmode.mode.mediator.Mediator;

public class Cpu extends Colleague{

	private Integer[] addrs ;
	
	
	public Cpu(Mediator mediator) {
		super(mediator);
	}

	public void executeDate(String cmd,Integer ... addrs){
		if("w".equals(cmd)){
			System.out.println( "cpu 执行w命令 文件路径内存地址：" + addrs[0]+ " 文件内容内存地址：" + addrs[1] );
			this.addrs = addrs ;
		}
		
		this.getMediator().change(this);
	}

	public Integer getAddr(Integer i) {
		return addrs[i];
	}

	
	
}
