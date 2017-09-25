package com.cz.designmode.mode.mediator;

import com.cz.designmode.mode.mediator.colleague.Cpu;
import com.cz.designmode.mode.mediator.colleague.HardDisk;
import com.cz.designmode.mode.mediator.colleague.KeyBoard;
import com.cz.designmode.mode.mediator.colleague.Memory;

public class FileSaveMediator implements Mediator {

	private KeyBoard keyBoard ;
	
	private Cpu cpu ;
	
	private HardDisk hardDisk ;
	
	private Memory memory ;
	
	
	@Override
	public void change(Colleague colleague) {
		
		if( colleague == keyBoard ){
			String temp = keyBoard.getData() ;
			if( temp.startsWith(":w ") ){
				String[] command = temp.split(" ") ;
				String fileName = command[1] ;
				this.memory.writeData(fileName);
			}
		}else if( colleague == memory ){
			cpu.executeDate("w" , memory.getLastDataAddr(), SystemCache.DATA_ADDR);
		}else if( colleague == cpu ){
			hardDisk.write(memory.getData(cpu.getAddr(0)), memory.getData(cpu.getAddr(1)));
		}
		
	}

	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}

	public void setHardDisk(HardDisk hardDisk) {
		this.hardDisk = hardDisk;
	}

	public void setMemory(Memory memory) {
		this.memory = memory;
	}

	public void setKeyBoard(KeyBoard keyBoard) {
		this.keyBoard = keyBoard;
	}
	
}
