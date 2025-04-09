package lab;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIPAddress {
    public static void main(String[] args) {
        // List of hostnames
        String[] hostnames = {
            "www.scst.edu.np",
            "www.google.com",
            "www.facebook.com"
        };

        // Iterate through each hostname and get its IP address
        for (String host : hostnames) {
            try {
                InetAddress address = InetAddress.getByName(host);
                System.out.println("IP Address of " + host + " : " + address.getHostAddress());
            } catch (UnknownHostException e) {
                System.out.println("Unable to resolve host: " + host);
            }
        }
    }
}

