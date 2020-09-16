import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class Decrypt {

	public static final String DECRYPTION_HOST ="localhost";
	public static final int DECRYPTION_PORT=1220;
	
	public static void main(String[] args) throws Exception {
		
		// Read the shared secret key
		SecretKey KEY = CryptKey.readSecretKey();
		byte[] ciphertext = null;
		
		// Recieve ciphertext from the network
		System.out.println("Listening for ciphertext...");
		ServerSocket ss = new ServerSocket(DECRYPTION_PORT);
		try {
			Socket s = ss.accept();
			try {
				DataInputStream is = new DataInputStream(s.getInputStream());
				ciphertext = new byte[is.readInt()];
				is.read(ciphertext);
			}
			finally {
				try {
					s.close();
				}
				catch(Exception e) {
					// Do Nothing
				}
			}
		}
		finally {
			try {
				ss.close();				
			}
			catch(Exception e) {
				// Do Nothing
			}
		}
		
		// Decrypt the recieved ciphertext using the secret key
		System.out.println("Decrypting the message....");
		Cipher cipher = Cipher.getInstance(CryptKey.ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, KEY);
		System.out.println(new String(cipher.update(ciphertext)));
		System.out.println(new String(cipher.doFinal()));
		
	}
}
