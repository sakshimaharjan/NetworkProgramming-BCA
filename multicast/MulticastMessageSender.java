package multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.io.*;
public class MulticastMessageSender {
public static void main(String[] args)throws IOException {
//open the multicast soceket on port 3456
MulticastSocket socket = new MulticastSocket();
//address for the multicaste group
InetAddress group = InetAddress.getByName("225.4.5.6");
// Create the multicast message and stored in msg variable
String msg = "Hello this is a multicast program";
// Send the multicast packet to the multicast group
DatagramPacket outPacket = new DatagramPacket(msg.getBytes(),msg.length(),group,3456);
socket.send(outPacket);
socket.close();
}
}
