package lab12;

import java.io.*;
import java.net.*;

public class DayTimeClient {
    public static void main(String[] args) {
        // Specify the server address and port to connect to
        String serverAddress = "172.22.16.1"; // Replace with the address of your server
        int port = 5000; // Port where the server is running

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Read the server's response (current date and time)
            String response = in.readLine();
            System.out.println("Received from server: " + response);

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
