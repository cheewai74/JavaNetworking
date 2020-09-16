import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.crypto.*;

public class Encrypt {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String plaintext = prompt("plaintext: ");
		
		// Read the shared secret key
		SecretKey key = CryptKey.readSecretKey();
		
		// Encrypt the message with the secret key
		System.out.println("Encrypting the message...");
		Cipher cipher = Cipher.getInstance(CryptKey.ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] ciphertext = cipher.doFinal(plaintext.getBytes());
		
		// Send the ciphertext over the network
		Socket s = new Socket(Decrypt.DECRYPTION_HOST, Decrypt.DECRYPTION_PORT);
		
		try {
			DataOutputStream os = new DataOutputStream(s.getOutputStream());
			os.writeInt(ciphertext.length);
			os.write(ciphertext);
			os.close();
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
	
	public static String prompt(String prompt) throws IOException {
		System.out.println(prompt);
		System.out.flush();
		BufferedReader input = 
				new BufferedReader(new InputStreamReader(System.in));
		String response = input.readLine();
		System.out.println();
		return response;
	}

}
