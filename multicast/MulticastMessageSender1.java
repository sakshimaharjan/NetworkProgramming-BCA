package multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastMessageSender1 {
    public static void main(String[] args) throws Exception {
        MulticastSocket socket = new MulticastSocket();
        InetAddress group = InetAddress.getByName("172.22.16.1");

        String msg = "Hello this is a multicast program. I am sakshi";
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.length(), group, 3456);
        socket.send(packet);
        socket.close();

        System.out.println("📤 Multicast message sent!");
    }
}
