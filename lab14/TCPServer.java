package lab14;
import java.io.*;
import java.net.*;
class SimpleTCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        Socket client = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        out.println("Hello from Server");
        System.out.println("Client says: " + in.readLine());
        client.close();
        serverSocket.close();
    }
}
