package lab15;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPDaytimeClient {
    public static void main(String[] args) {
        String serverHost = "localhost";
        int port = 9876;

        try {
            DatagramSocket socket = new DatagramSocket();

            InetAddress serverAddress = InetAddress.getByName(serverHost);

            byte[] buffer = new byte[1]; // Empty request
            DatagramPacket request = new DatagramPacket(buffer, buffer.length, serverAddress, port);
            socket.send(request);

            byte[] responseBuffer = new byte[1024];
            DatagramPacket response = new DatagramPacket(responseBuffer, responseBuffer.length);
            socket.receive(response);

            String time = new String(response.getData(), 0, response.getLength());
            System.out.println("Daytime response from server: " + time);

            socket.close();
        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
