package lab16;
import java.io.*;
import java.net.*;
class UDPEchoServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(4446);
        byte[] buf = new byte[256];
        while (true) {
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            socket.send(packet); // echo
        }
    }
}
