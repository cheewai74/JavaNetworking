
public class StackVariable extends Thread{
	
	public static int modify(int amount) {
		int stack = 0;
		for(int i=0; i <100; i++) {
			stack = stack + amount;
			System.out.println("stack = "+ stack);
		}
		return stack;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackVariable t = new StackVariable();
		t.start();
		System.out.println("FINISHED main: stack = " + modify(+1));
	}
	
	public void run() {
		System.out.println("FINISHED thread: stack = " + modify(-1));
	}

}
