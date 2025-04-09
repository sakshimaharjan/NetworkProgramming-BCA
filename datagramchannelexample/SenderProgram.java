package datagramchannelexample;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
public class SenderProgram {
    public static void main(String[] args)throws Exception {
        DatagramChannel channel = DatagramChannel.open(); 
        // Open a DatagramChannel for sending messages
        String message = "Hello, Receiver!"; // Create the message to be sent
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes()); // Wrap the message in a ByteBuffer
        InetSocketAddress receiverAddress = new InetSocketAddress("localhost", 4321); // Create the receiver's address
        channel.send(buffer, receiverAddress); // Send the message to the receiver
        System.out.println("Message sent successfully.");
    }
}