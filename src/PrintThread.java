
public class PrintThread extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PrintThread p = new PrintThread();
		p.start();
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
