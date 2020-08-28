
public class PrintRunnableThread implements Runnable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread(new PrintRunnableThread());
		t.start();
		for(;;) {
			System.out.print("M");
		}
	}


	public void run() {
		// TODO Auto-generated method stub
		for(;;) {
			System.out.print("T");
		}
	}
	
	

}
