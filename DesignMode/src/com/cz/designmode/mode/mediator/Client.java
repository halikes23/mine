package com.cz.designmode.mode.mediator;

import com.cz.designmode.mode.mediator.colleague.Cpu;
import com.cz.designmode.mode.mediator.colleague.HardDisk;
import com.cz.designmode.mode.mediator.colleague.KeyBoard;
import com.cz.designmode.mode.mediator.colleague.Memory;

public class Client {

	public static void main(String[] args) {
		
		FileSaveMediator mediator = new FileSaveMediator() ;
		
		Memory memory = new Memory(mediator);
		Cpu cpu = new Cpu(mediator);
		KeyBoard keyBoard = new KeyBoard(mediator) ;
		HardDisk hardDisk = new HardDisk(mediator) ;
		
		SystemCache.DATA_ADDR = memory.writeData("写到内存的文件内容（省略了写键盘输入等过程）");
		
		mediator.setCpu(cpu);
		mediator.setHardDisk(hardDisk);
		mediator.setMemory(memory);
		mediator.setKeyBoard(keyBoard);
		
		keyBoard.input(":w /data/temp/file");
		
	}
	
}
