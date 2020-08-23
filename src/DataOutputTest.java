import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputTest {
	
	public DataOutputTest() {
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileOutputStream fileOut = null;
		DataOutputStream dataOut = null;
		
		try {
			fileOut = new FileOutputStream("datatest.txt");
			dataOut = new DataOutputStream(fileOut);
			
			dataOut.writeBoolean(true);
			dataOut.writeInt(98765);
			dataOut.writeFloat(1.5f);
			dataOut.writeLong(3210L);
			dataOut.writeDouble(25.65d);
			dataOut.flush();
			dataOut.close();
		}
		catch(IOException E){
			E.printStackTrace();
		}
		
		
		
	}

}
