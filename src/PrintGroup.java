
public class PrintGroup implements Runnable{
	
	public void run() {}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a new thread group and put a couple of threads in it.
		
		ThreadGroup tg = new ThreadGroup("New Group");
		tg.setMaxPriority(Thread.NORM_PRIORITY);
		Thread t1 = new Thread(tg, new PrintGroup(), "Thread 1");
		Thread t2 = new Thread(tg, new PrintGroup(), "Thread 2");
		
		ThreadGroup parent = Thread.currentThread().getThreadGroup();
		while(parent.getParent()!=null ) {
			parent = parent.getParent();
		}
		
		parent.list();
	}

}
