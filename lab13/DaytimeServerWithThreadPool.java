package lab13;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DaytimeServerWithThreadPool {

    private static final int PORT = 5000;             // Port to listen on
    private static final int THREAD_POOL_SIZE = 10;   // Number of threads in the pool

    public static void main(String[] args) {
        // Create a fixed thread pool
        ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Daytime Server with Thread Pool started on port " + PORT);

            // Server runs forever
            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Client connected: " + clientSocket.getInetAddress());

                    // Handle client in a separate thread from the pool
                    threadPool.submit(() -> handleClient(clientSocket));

                } catch (IOException e) {
                    System.err.println("Error accepting client: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    // Method to handle client communication
    private static void handleClient(Socket clientSocket) {
        try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            String currentTime = new Date().toString();
            out.println("Current Date & Time: " + currentTime);
            System.out.println("Sent to " + clientSocket.getInetAddress() + ": " + currentTime);
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Couldn't close client socket: " + e.getMessage());
            }
        }
    }
}
