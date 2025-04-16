package multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.io.*;
public class MulticastMessageReceiver {
public static void main(String[] args)throws IOException {
//1.open the multicast soceket on port 3456
MulticastSocket socket = new MulticastSocket(3456);
//2. Join a multicast group by specifying the multicast address
InetAddress group = InetAddress.getByName("225.4.5.6");
socket.joinGroup(group);
//3.Create a byte array to store incoming data maximum 1024 bits
byte [] buffer = new byte[1024];
//4. Create a DatagramPacket for receiving multicast packets
DatagramPacket inPacket = new DatagramPacket(buffer,buffer.length);
//5. Receive a multicast packet
socket.receive(inPacket);
//4.Convert the received data to a string and print in the console
System.out.println(new String(buffer));
socket.close();
}
}
