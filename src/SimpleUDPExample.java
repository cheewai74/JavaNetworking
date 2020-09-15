import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SimpleUDPExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int port = 5264;
		
		// Create Datagram Socket
		DatagramSocket socket = new DatagramSocket(port);
		socket.setSoTimeout(5000);
		
		// Create datagram payload + set destination to self
		String outMessage = "Hello UDP World!";
		byte[] data = outMessage.getBytes();
		DatagramPacket packet = 
				new DatagramPacket(data, data.length,InetAddress.getByName("localhost"),port);
		
		// Send datagram (to ourself)
		System.out.println("Sending Message: "+outMessage);
		socket.send(packet);

		/* prepare to recieve datagram:
		 * becos we reuse the DatagramPacket instance 
		 * we must reset it's length even though we replace its data
		 * buffer!
		 */
		
		packet.setData(new byte[512]);
		packet.setLength(512);
		
		// Recieve Datagram (may time out)
		System.out.println("Waiting for datagram ...");
		socket.receive(packet);
		
		// print result
		String inMessage = new String(packet.getData(), 0, packet.getLength());
		System.out.println("Recieve message: "+inMessage);
		
		socket.close();
	}

}