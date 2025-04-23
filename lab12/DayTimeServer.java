package lab12;

import java.io.*;
import java.net.*;
import java.util.Date;

public class DayTimeServer {
    public static void main(String[] args) {
        // Specify your own server address and port
        String serverAddress = "172.22.16.1"; // Change this to your server's address
        int port = 5000; // Port to listen on

        try (ServerSocket serverSocket = new ServerSocket(port, 50, InetAddress.getByName(serverAddress))) {
            System.out.println("Daytime Server started on " + serverAddress + " at port " + port);

            while (true) {
                // Accept client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Send the current date and time to the client
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                String currentTime = new Date().toString();
                out.println("Current Date & Time: " + currentTime);
                System.out.println("Sent to client: " + currentTime);

                // Close the client connection
                clientSocket.close();
            }

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
