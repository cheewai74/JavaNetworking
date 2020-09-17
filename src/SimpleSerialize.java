import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class SimpleSerialize {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Serialize the current date to a file
		File myfile = new File("data.date");
		myfile.createNewFile();
		
		// This version of FileOutputStream() method allows the file to be
		// appended to rather than overwritten
		
		FileOutputStream oFileOutputStream = new
				FileOutputStream("data.dat", true);
		ObjectOutputStream oObjectOutputStream = new
				ObjectOutputStream(oFileOutputStream);
		oObjectOutputStream.writeObject("Today");
		oObjectOutputStream.writeObject(new Date());
		
		// Flush and close the output stream 
		oObjectOutputStream.flush();
		oObjectOutputStream.close();
	}

}
