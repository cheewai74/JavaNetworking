import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class InputBufferTest {
	
	public InputBufferTest() {};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			byte[] b = new byte[] {
				(byte)	-8, (byte) -4, (byte) -2, (byte) 0, (byte) 2, (byte) 4
			};
			
			ByteArrayInputStream byteIn = new ByteArrayInputStream(b);
			BufferedInputStream bis = new BufferedInputStream(byteIn);
			
			int readByte = bis.read();
			System.out.println("Reading the first byte: "+((readByte <=0)?readByte:(readByte-256)));
			
			bis.mark(16);
			
			readByte = bis.read();
			System.out.println("Reading the second byte: "+((readByte <=0)?readByte:(readByte-256)));
			
			readByte = bis.read();
			System.out.println("Reading the third byte: "+((readByte <=0)?readByte:(readByte-256)));
			
			readByte = bis.read();
			System.out.println("Reading the fourth byte: "+((readByte <=0)?readByte:(readByte-256)));
			
			bis.reset();
			
			readByte = bis.read();
			System.out.println("Reading the second byte again: "+((readByte <=0)?readByte:(readByte-256)));
			
			
			
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
