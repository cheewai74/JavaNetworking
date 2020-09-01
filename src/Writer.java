
import java.util.Vector;

public class Writer {
	
	public void fill(Vector queue) {
		for(int i =0; i< 20;i++) {
			queue.add(new Integer(i));
			synchronized(queue) {
				queue.notifyAll();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// This vector will be the communication channel 
		// between the writers and the readers.
		Vector queue = new Vector();
		Writer writer1 = new Writer();
		
		// Start 2 readers
		Reader reader1 = new Reader(queue, "Reader 1");
		reader1.start();
		Reader reader2 = new Reader(queue, "Reader 2");
		reader2.start();
		
		// Fill up the queue. The waiting readers will wake up.
		// and start emptying the queue.
		
		writer1.fill(queue);
				
	}

}
