import java.nio.*;

public class BufferTest {
	
	public static void showParameters(ByteBuffer buffer, String message)
	{
		System.out.println();
		System.out.println("" +message);
		System.out.println("Capacity: "+ buffer.capacity());
		System.out.println("Limit: "+ buffer.limit());
		System.out.println("Position: "+ buffer.position());
		System.out.println("Remaining: " +buffer.remaining());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

			ByteBuffer buffer = ByteBuffer.allocate(512);
			showParameters(buffer, "Buffer Allocated:");
			
			buffer.putFloat(1.1f);
			buffer.putFloat(2.2f);
			buffer.mark();
			buffer.putFloat(3.3f);
			
			showParameters(buffer, "Added 3 floats and place a mark at the 8th place");
			
			buffer.reset();
			showParameters(buffer, "Reset the buffer:");
			
			buffer.getFloat();
			showParameters(buffer, "Get a float (moving the position ahead):");
			
			buffer.rewind();
			showParameters(buffer, "Rewind the buffer:");
			
			buffer.flip();
			showParameters(buffer, "Flip the buffer:");
			
			buffer.limit(8);
			showParameters(buffer, "Set the limit to 8 bytes and try to add 9 bytes:");
			
			try {
				byte[] bytes = new byte[9];
				buffer.put(bytes);
			}
			catch(BufferOverflowException e) {
				System.out.println("Buffer Overflow: " + e);
			}
			
			
			
	}

}
