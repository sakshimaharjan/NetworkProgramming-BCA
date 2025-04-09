package datagramsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class sendData {
    public static void main(String[] args) throws IOException{
        DatagramSocket ds = new DatagramSocket();
        String str = "Message send by Datagram socket";
        InetAddress localhost = null;
        DatagramPacket dp = new DatagramPacket(str.getBytes(),str.length(),localhost,3000);
        ds.send(dp);
        ds.close();
    }
}
