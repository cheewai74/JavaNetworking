import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.Date;

public class SimpleDeserialize {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		// Deserialize a string and a date from a file
		FileInputStream oFileInputStream = new FileInputStream("data.dat");
		ObjectInputStream oObjectInputStream = new
				ObjectInputStream(oFileInputStream);
		
		String sDate = (String)oObjectInputStream.readObject();
		Date dtDate = (Date)oObjectInputStream.readObject();
		
		System.out.println(sDate);
		System.out.println(dtDate);
		
		// Close the stream
		oObjectInputStream.close();

	}

}
