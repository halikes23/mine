package practice.basic;

public class Single {

	private int count = 0 ;
	
	private static Single SINGLE ;
	
	public Single(int count){
		this.count = count ;
	}
	
	public static synchronized void init(int i){
		
		if( SINGLE == null ){
			try {
				Thread.sleep(100L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SINGLE = new Single(i) ;
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {

		for(int i = 0 ; i < 100 ; i ++){
			final int temp = i ;
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					init(temp) ;
				}
			}) ;
			thread.start();
		}
		
		Thread.sleep(2000L);
		
		System.out.println(SINGLE.getCount());
		
	}

	public int getCount() {
		return count;
	}
	
}
