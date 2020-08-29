
public class PrintStatic implements Runnable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new PrintStatic(), "First Thread");
		Thread t2 = new Thread(new PrintStatic(), "Second Thread");
		
		// Now use the Thread Static method to look at these threads.
		int numThreads = Thread.activeCount();
		System.out.println(" The number of threads is "+numThreads);
		Thread[] threads = new Thread[numThreads];
		Thread.enumerate(threads);
		for(int i =0; i < threads.length; i++) {
			System.out.println(" Threads named: "+threads[i].getName());
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
			
		}
		catch(InterruptedException e) {
			System.out.println("On no!, I was interrupted!");
		}
	}
	
	private void aMethod() {
		Thread.dumpStack();
	}

}
