
public class PrintStop3 extends Thread{
	
	private boolean should_stop = false;
	
	public void run() {
		// TODO Auto-generated method stub
		for(;;) {
			// This is a safe place to quit.
			// Check to see if I should stop
			
			if(should_stop) {
				break;
			}
			
			try {
				sleep(1000 * 60 * 60 * 24); // sleep for one day
			}
			catch(InterruptedException e) {
				if(should_stop) {
					break;
				}
			}
			
			System.out.print(".");
		}
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintStop3 t = new PrintStop3();
		t.start();
		try {
			sleep(5000);
		}
		catch(InterruptedException e) {
			
		}
		
		// Signal the flat to stop by setting the boolean flag
		t.should_stop = true;
		
		// Wake it up by interrupting it
		t.interrupt();
		
		// Wait for the thread to finish 
		try {
			t.join();
		}
		catch(InterruptedException e) {
			System.out.println("The thread has finished");
		}
	}

}
