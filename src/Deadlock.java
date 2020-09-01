
public class Deadlock extends Thread{
	
	// 2 Objects used for syncrhonization
	static Object o1 = new Object();
	static Object o2 = new Object();
	
	// if doO1First is true, the thread will synchronize on o1 then o2.
	// if doO1First is false, the thread will synchronize on o2 then o1.
	
	boolean doO1First;
	
	public Deadlock(boolean doO1First) {
		this.doO1First = doO1First;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// This thread will synchronize on o1 then o2
		Deadlock d1 = new Deadlock(true);
		d1.start();
		
		// This thread will synchronize on o2 then o1
		Deadlock d2 = new Deadlock(false);
		d2.start();
	}


	
	public void run() {
		// TODO Auto-generated method stub
		for(;;) {
			
			if(doO1First) {
				synchronized (o1) { // acquire o1's monitor
					synchronized(o2) { // acquire o2's monitor
						System.out.println(Thread.currentThread().getName()
								+ " Got both monitors");
									// release o2's monitor
						            // release o2's monitor
					}
				}
			}
			else {
				synchronized (o1) { // acquire o1's monitor
					synchronized(o2) { // acquire o2's monitor
						System.out.println(Thread.currentThread().getName()
								+ " Got both monitors");
									// release o2's monitor
						            // release o2's monitor
					}
				}
			}
		} // end for(;;) loop
	}
	
	

}
