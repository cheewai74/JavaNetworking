/***
 * Remarks
 * At command prompt: telnet localhost 5000
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServerTest {
	
	public SimpleServerTest() {}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			ServerSocket server = new ServerSocket(5000);
			System.out.println("Listening for incomming connection...");
			Socket s = server.accept();
			
			char[] buf = new char[64];
			int charsRead = 0;
			
			File f = new File("Resource\\serverfile.txt");
			FileReader fr = new FileReader(f.getAbsolutePath());
			OutputStreamWriter ow = new OutputStreamWriter(s.getOutputStream());
			while((charsRead = fr.read(buf)) > -1) {
				ow.write(buf,0, charsRead);
			}
			
			ow.close();
			fr.close();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
