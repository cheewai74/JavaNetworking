import java.applet.*;
import java.awt.Event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SecurityApp extends java.applet.Applet{

	private SecurityTestWindow window;
	
	public void init() {
		window = new SecurityTestWindow("Applet Security Test");
		SecurityTestWindow window = new SecurityTestWindow("Application Security Test");
		window.addWindowListener(new WindowAdapter() {
			public void windlowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		window.showTestResults();
	}
	
	public void destroy() {
		window.dispose();
	}
}
