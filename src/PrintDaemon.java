
public class PrintDaemon extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintDaemon p = new PrintDaemon();
		p.start();
		
		for(int i=0; i<30; i++) {
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
