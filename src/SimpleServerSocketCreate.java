import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServerSocketCreate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket server = null;
		int port = 4000;
		
		try {
			System.out.println("Attempting to bind to TCP port "+ port + "...");
			server= new ServerSocket(port);
		}
		catch(IOException e) {
			System.err.println("Error binding to port: " 
								+ e.getClass().getName() + ": "+e.getMessage());
			System.exit(1);
		}
		catch(SecurityException e ) {
			System.err.println("The security manager refused permission to " +
								"bind to port "+ port+ " was denied: "+
								e.getMessage());
			System.exit(1);
		}
		
		System.out.println("Created socket bound to "+
							server.getInetAddress().getHostName() +":"
							+ server.getLocalPort());
		
		while(true) {
			System.out.println("Listening to connections ...");
			
			try {
				Socket socket = server.accept();
				System.out.println("Connection from "+
									socket.getInetAddress().getHostName()+" :"
									+ socket.getPort());
				
				// Normally this is where we'd spawn a thread to perform communications
				
				socket.close();
			}
			catch(IOException e) {
				System.err.println("A communications error occured while "
						+ "waiting for, or establishing a TCP "
						+ "connection: "+e.getMessage());
			}
			catch(SecurityException e) {
				System.err.println("Unauthorized client connection: "
										+e.getMessage());
			}
			catch(Throwable e) {
				System.err.println("Unexpected exception: "+e.getClass().getName()+": "+e.getMessage());
			}
		}
	}

}
