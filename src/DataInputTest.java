import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputTest {
	
	public DataInputTest() {}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileInputStream fileIn = null;
		DataInputStream dataIn = null;
		
		try {
			fileIn = new FileInputStream("datatest.txt");
			dataIn = new DataInputStream(fileIn);
			System.out.println("boolean:"+dataIn.readBoolean());
			System.out.println("int: "+dataIn.readInt());
			System.out.println("float: "+dataIn.readFloat());
			System.out.println("long: "+dataIn.readLong());
			System.out.println("double: "+dataIn.readDouble());
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}

 }
