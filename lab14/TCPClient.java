package lab14;
import java.io.*;
import java.net.*;
class SimpleTCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("172.22.16.1", 5000);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        System.out.println("Server says: " + in.readLine());
        out.println("Hello Server!");
        socket.close();
    }
}