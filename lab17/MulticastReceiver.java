package lab17;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastReceiver {
    public static void main(String[] args) {
        String multicastGroup = "230.0.0.1";
        int port = 4446;

        try (MulticastSocket socket = new MulticastSocket(port)) {
            InetAddress group = InetAddress.getByName(multicastGroup);
            socket.joinGroup(group); // Join the multicast group

            System.out.println("Listening for messages on multicast group...");

            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            socket.receive(packet);

            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received message: " + received);

            socket.leaveGroup(group); // Optional: Leave the group

        } catch (Exception e) {
            System.out.println("Receiver Error: " + e.getMessage());
        }
    }
}
