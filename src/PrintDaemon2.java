
public class PrintDaemon2 extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintDaemon2 p = new PrintDaemon2();
		p.setDaemon(true);
		p.start();
		
		for(int i =0; i<30; i++) {
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
