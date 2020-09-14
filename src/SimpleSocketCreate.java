import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleSocketCreate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String host = "localhost";
		int port = 4000;
		
		try {
			System.out.println("Attempting to connect a TCP service on "
								+ host+ ":"+port+" ...");
			
			Socket socket = new Socket(host, port);
			System.out.println("Connection established !");
			
			// Normally this is where we'd perform communications
			socket.close();
		}
		catch(UnknownHostException e) {
			System.err.println("Could not resolve host name: " + e.getMessage());
			
		} 
		
		catch (IOException e) {
			System.err.println("A communication error occured: "
		                         + e.getClass().getName() +": " +e.getMessage());
		}
		
		catch(SecurityException e ) {
			System.err.println("The security manager refused permission to " +
								"connect to the remote TCP service: "+
								e.getMessage());
		}

	}

}
