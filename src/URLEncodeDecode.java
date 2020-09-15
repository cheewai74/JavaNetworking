import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncodeDecode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length != 1) {
			System.err.println("Usage: URLEncodeDecode <string>");
			System.exit(1);
		}
		
		System.out.println("Original: " +args[0]);
		String encoded = URLEncoder.encode(args[0]);
		System.out.println("Encoded: " + encoded);
		String decoded = URLDecoder.decode(encoded);
		System.out.println("Decoded: " +decoded);
	}

}
