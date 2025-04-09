package lab;

import java.net.*;

public class NetworkDetails {
    public static void main(String[] args) throws Exception {
        InetAddress ip = InetAddress.getLocalHost();
        byte[] mac = NetworkInterface.getByInetAddress(ip).getHardwareAddress();

        System.out.println("IP Address: " + ip.getHostAddress());
        System.out.print("MAC Address: ");
        for (int i = 0; i < mac.length; i++) {
            System.out.printf("%02X%s", mac[i], (i < mac.length - 1) ? ":" : "");
        }
    }
}
