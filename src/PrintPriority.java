
public class PrintPriority extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintPriority t = new PrintPriority();
		t.setPriority(Thread.MAX_PRIORITY);
		t.start();
		for(;;) {
			System.out.print("M");
		}
		
			
	}
	
	public void run() {
		for(;;) {
			System.out.print("T");
		}
	}

}
