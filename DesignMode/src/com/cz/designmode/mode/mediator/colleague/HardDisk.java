package com.cz.designmode.mode.mediator.colleague;

import com.cz.designmode.mode.mediator.Colleague;
import com.cz.designmode.mode.mediator.Mediator;

public class HardDisk extends Colleague{

	public HardDisk(Mediator mediator) {
		super(mediator);
	}
	
	public void write(String fileName , String data){
		System.out.println( "文件保存到：" + fileName );
		System.out.println( "文件内容为：" + data );
	}

}
