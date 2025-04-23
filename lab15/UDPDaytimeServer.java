package lab15;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UDPDaytimeServer {
    public static void main(String[] args) {
        int port = 9876;

        try (DatagramSocket socket = new DatagramSocket(port)) {
            System.out.println("UDP Daytime Server is running on port " + port);

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                socket.receive(request);

                String currentTime = LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                byte[] responseData = currentTime.getBytes();

                DatagramPacket response = new DatagramPacket(
                        responseData,
                        responseData.length,
                        request.getAddress(),
                        request.getPort()
                );

                socket.send(response);
                System.out.println("Sent time to " + request.getAddress());
            }
        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}

