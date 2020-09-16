
import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class CryptKey {

	public static final String ALGORITHM = "DESede";
	public static final String KEY_FILENAME ="key";
	
	public static void main(String[] args) throws Exception {
		
		int keysize = Integer.parseInt(args[0]);
		
		// Create a secret key
		System.out.println("Generating key, size "+keysize+"...");
		KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM);
		kg.init(keysize);
		SecretKey key = kg.generateKey();
		
		// Write the key out to a disk file
		System.out.println("Writing to disk ....");
		OutputStream os = new FileOutputStream(KEY_FILENAME);
		try {
			os.write(key.getEncoded());
		}
		finally{
			try {
				os.close();
			}
			catch(Exception e) {
				// Do Nothing
			}
		}
	}
	
	public static SecretKey readSecretKey() throws Exception {
		
		// Read the secret key
		System.out.println("Reading Key...");
		byte[] keyBuffer = new byte[(int)new File("key").length()];
		InputStream is = new FileInputStream("key");
		try {
			is.read(keyBuffer);
		}
		catch(Exception e) {
			// do nothing 
		}
		System.out.println("Creating opague key...");
		return new SecretKeySpec(keyBuffer, ALGORITHM);
	}
	
}
