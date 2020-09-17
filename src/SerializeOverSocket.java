import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class SerializeOverSocket {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

			Socket oSocket = new Socket("SomeHost", 4000);
			OutputStream oOutputStream = oSocket.getOutputStream();
			
			// Create the output stream. Chain the output stream to it.
			ObjectOutputStream oObjectOutputStream = 
					new ObjectOutputStream(oOutputStream);
			
			// Write the object to the output stream
			oObjectOutputStream.writeObject("Today");
			oObjectOutputStream.writeObject(new Date());
			
			// Flush and close the output stream
			oObjectOutputStream.flush();
			oObjectOutputStream.close();
	};

}
