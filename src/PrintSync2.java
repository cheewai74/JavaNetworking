
public class PrintSync2 {
	
	public static String syncObject ="sync";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long count = 0;
		long start = System.currentTimeMillis();
		
		for(int i =0; i<1000000; i++) {
			
			// Gratuitous syncrhonization
			synchronized(syncObject) {
			// Do something useful
			count = count +1;
			}
		}
		
		long  stop = System.currentTimeMillis();
		System.out.println("Time = "+ (stop - start) + " milliseconds");
	}

}
