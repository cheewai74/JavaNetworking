import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URLConnection;

public class SecurityTestWindow extends Frame{
	
	private TextArea textArea;
	

	public static void main(String[] args){
		// TODO Auto-generated method stub
		SecurityTestWindow window = new SecurityTestWindow("Application Security Test");
		window.addWindowListener(new WindowAdapter() {
			public void windlowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		window.showTestResults();
	}
	
	public SecurityTestWindow(String title) {
		super(title);
		
		textArea = new TextArea();
		textArea.setEditable(false);
		add(textArea);
		pack();
		show();
	}
	
	public void showTestResults() {
		
		println("Running Tests...");
		try {
			fileTest("/");
		}
		catch(Exception e) {
			println(e);
		}
		
		try {
			socketTest("https://www.google.com");
		}
		catch(Exception e) {
			println(e);
		}
		
		try {
			systemTest("user.home");
		}
		catch(Exception e) {
			println(e);
		}
		
		println("Done.");
		
	}
	
	private void fileTest(String path) {
		String[] files = new java.io.File(path).list();
		if(files.length > 0) {
			println("First file in "+ path+" is"+files[0]);
		}
	}
	
	private void socketTest(String url) throws java.io.IOException{
		URLConnection connection = new java.net.URL(url).openConnection();
		connection.connect();
		println(url + " is "+connection.getContentLength()+ " bytes");
		connection.getInputStream().close();
	}
	
	private void systemTest(String property) {
		println(property + " has value " +System.getProperty(property));
	}
	
	private void println(Object toPrint) {
		textArea.append(toPrint +"\n");
	}

}
