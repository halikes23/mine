package practice.basic;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimpleThreadDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService es = Executors.newCachedThreadPool() ;
		
		Future<String> rst = es.submit(new MyCallable()) ;

	}
	
	
}
