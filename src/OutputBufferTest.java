import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class OutputBufferTest {
	
	public OutputBufferTest() {};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ByteArrayOutputStream byteOut = new  ByteArrayOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(byteOut);
			
			bos.write(new byte[255]);
			System.out.println("We have written 255 bytes and the bytes stream shows: "
			                    +byteOut.size() +" bytes");
			
			bos.flush();
			System.out.println("After flushing the buffer, the byte stream shows: "
								+byteOut.size()+ " bytes");
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
