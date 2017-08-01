package practice.basic;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String>{

	@Override
	public String call() throws Exception {
		System.out.println("Callable : 1");
		
		Thread.sleep(5000L);
		
		return "result";
	}
	
}
