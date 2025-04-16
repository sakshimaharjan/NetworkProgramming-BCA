package multithreadedserver;

import java.io.*;
import java.net.*;

// Server class that implements Runnable interface
class MultiThreadedServer implements Runnable {
    private ServerSocket serverSocket;    // Server socket to listen for connections

    // Constructor to initialize server on a specific IP and port
    public MultiThreadedServer(String bindAddress, int port) throws IOException {
        serverSocket = new ServerSocket(); 
        serverSocket.bind(new InetSocketAddress(bindAddress, port)); // Bind to specific IP & port
        System.out.println("Server started on " + bindAddress + ":" + port);
    }

    @Override
    public void run() {
        while (true) {     // Keep server running to accept multiple clients
            try {
                // Accept a client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                
                // Create a new thread for each client
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                Thread clientThread = new Thread(clientHandler);
                clientThread.start(); // Start the client thread
            } catch (IOException e) {
                System.out.println("Error accepting client connection: " + e.getMessage());
            }
        }
    }
}



// Client handler class to manage communication with a client
class ClientHandler implements Runnable {
    private Socket clientSocket; // Client socket

    // Constructor to initialize client socket
    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            // Create input and output streams to communicate with client
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
            
            output.println("Welcome to the multi-threaded server!"); // Send welcome message to client
            String clientMessage;

            // Read messages from client and respond
            while ((clientMessage = input.readLine()) != null) {
                System.out.println("Client says: " + clientMessage);
                output.println("Server received: " + clientMessage); // Send response to client

                // Exit if client sends "stop"
                if (clientMessage.equalsIgnoreCase("stop")) {
                    break;
                }
            }

            // Close resources after communication ends
            input.close();
            output.close();
            clientSocket.close();
            System.out.println("Client disconnected.");
        } catch (IOException e) {
            System.out.println("Client communication error: " + e.getMessage());
        }
    }
}

// Main class to start the server
public class MultiThreadedServerApp {
    public static void main(String[] args) {
        String bindAddress = "192.168.1.75"; // Change this to your LAN IP
        int port = 8000; // Define the server port

        try {
            MultiThreadedServer server = new MultiThreadedServer(bindAddress, port); // Create server instance
            Thread serverThread = new Thread(server); // Create a new thread for server
            serverThread.start(); // Start server thread
        } catch (IOException e) {
            System.out.println("Error starting server: " + e.getMessage());
        }
    }
}
