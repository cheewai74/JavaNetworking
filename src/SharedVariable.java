
public class SharedVariable extends Thread{
	
	private static int shared =0;
	
	public static int modify(int amount) {
		for(int i=0; i <100; i++) {
			shared = shared + amount;
			System.out.println("shared = "+ shared);
		}
		return shared;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SharedVariable t = new SharedVariable();
		t.start();
		System.out.println("FINISHED main: shared = " + modify(+1));
	}
	
	public void run() {
		System.out.println("FINISHED thread: shared = " + modify(-1));
	}
}
