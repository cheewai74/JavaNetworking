import java.util.Vector;

public class Reader extends Thread{
	
	private Vector queue;
	
	// A name so we can tell the readers apart.
	private String name;
	
	public Reader(Vector queue, String name) {
		this.queue = queue;
		this.name = name;
	}
	
	public void run() {
		for(;;) {
			synchronized(queue) {
				while(queue.isEmpty()) {
					try {
						queue.wait();
					}
					catch(InterruptedException e) {
						// No Action
					}
				}
				
				// At this point the monitor has been re-acquired
				Object o = queue.remove(0);
				System.out.println(name + " got job number: " + o); // release the monitor at the end of the synchronized clock.
				
			}
		}
	}

}
