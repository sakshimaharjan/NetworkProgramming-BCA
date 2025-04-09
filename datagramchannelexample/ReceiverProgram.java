package datagramchannelexample;

import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
public class ReceiverProgram {
    public static void main(String[] args) throws Exception{
        // Open a DatagramChannel for receiving messages
        DatagramChannel channel = DatagramChannel.open(); 
        // Create the receiver's address
        InetSocketAddress receiverAddress = new InetSocketAddress("localhost", 4321); 
        // Bind the channel to the receiver's address
        channel.bind(receiverAddress); 
        // Create a ByteBuffer to receive the incoming message
        ByteBuffer buffer = ByteBuffer.allocate(1024); 

        channel.receive(buffer); // Receive the message
        buffer.flip(); // Prepare the buffer for reading
        // Create a byte array with the received data
        byte[] receivedData = new byte[buffer.remaining()]; 
        buffer.get(receivedData);
        // Convert the byte array to a string to extract the received message
        String message = new String(receivedData); 
        System.out.println("Received message: " + message); // Print the received message
    }
}