package lab11;
import java.io.*;
import java.net.*;
class LowPortScanner {
    public static void main(String[] args) {
        for (int port = 1; port <= 1024; port++) {
            try (Socket socket = new Socket("localhost", port)) {
                System.out.println("TCP Port in use: " + port);
            } catch (IOException ignored) {}
            try (DatagramSocket ds = new DatagramSocket(port)) {
                ds.close();
            } catch (SocketException e) {
                System.out.println("UDP Port in use: " + port);
            }
        }
    }
}