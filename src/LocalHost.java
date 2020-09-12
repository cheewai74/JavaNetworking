import java.net.InetAddress;

public class LocalHost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println("Local address: "+ address.getHostAddress());
			System.out.println("Local hostname: "+ address.getHostName());
		}
		catch(java.net.UnknownHostException e) {
			System.err.println("Cannot determine local hostname and address: " + e.getMessage());
			System.exit(1);
			
		}
	}

}
