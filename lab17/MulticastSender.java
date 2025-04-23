package lab17;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSender {
    public static void main(String[] args) {
        String multicastGroup = "230.0.0.1"; // Multicast address
        int port = 4446; // Port to send message

        try (MulticastSocket socket = new MulticastSocket()) {
            String message = "HELLO";
            byte[] buffer = message.getBytes();

            InetAddress group = InetAddress.getByName(multicastGroup);
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);

            socket.send(packet);
            System.out.println("Sent message: " + message);

        } catch (Exception e) {
            System.out.println("Sender Error: " + e.getMessage());
        }
    }
}
