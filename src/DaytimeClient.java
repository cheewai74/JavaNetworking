import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class DaytimeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sHostName;
		
		if(args.length > 0) {
			sHostName = args[0];
		}
		else {
			sHostName = "time.nist.gov";
		}
		
		
		try {
			// Open a socket to port 13, prepare to recieve daytime information
			Socket oSocket = new Socket(sHostName, 13);
			InputStream oTimeStream = oSocket.getInputStream();
			StringBuffer oTime = new StringBuffer();
			
			int iCharacter;
			
			// Fetch the daytime information
			while((iCharacter=oTimeStream.read())!= -1) {
				oTime.append((char) iCharacter);
			}
			
			// Convert Daytime to a string and output.
			String sTime = oTime.toString().trim();
			System.out.println("It is "+sTime+" at "+ sHostName + ".");
			
			// Close the stream and the socket
			oTimeStream.close();
			oSocket.close();
		}
		catch(UnknownHostException e) {
			System.err.println(e);
		}
		catch(IOException e) {
			System.err.println(e);
		}
	}

}
