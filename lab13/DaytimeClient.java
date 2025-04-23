package lab13;

import java.io.*;
import java.net.*;

public class DaytimeClient {
    public static void main(String[] args) {
        // Server address and port
        String serverAddress = "172.22.16.1"; // Change to your server IP if needed
        int port = 5000;

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Read and print the response from the server
            String serverResponse = in.readLine();
            System.out.println("Received from server: " + serverResponse);

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
