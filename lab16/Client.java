package lab16;
import java.io.*;
import java.net.*;
class UDPEchoClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        byte[] buf = "Hello".getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4446);
        socket.send(packet);
        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        System.out.println("Echoed: " + new String(packet.getData(), 0, packet.getLength()));
        socket.close();
    }
}