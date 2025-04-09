package lab;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddressType {
    public static void main(String[] args) {
        String[] ipAddresses = {
            "8.8.8.8",            // Google Public DNS (IPv4)
            "2001:4860:4860::8888", // Google Public DNS (IPv6)
            "172.16.254.1",       // Private IPv4 address
            "invalid_ip_address"  // Invalid IP format
        };

        for (String ip : ipAddresses) {
            try {
                InetAddress inetAddress = InetAddress.getByName(ip);
                
                if (inetAddress instanceof java.net.Inet4Address) {
                    System.out.println(ip + " is an IPv4 address.");
                } else if (inetAddress instanceof java.net.Inet6Address) {
                    System.out.println(ip + " is an IPv6 address.");
                } else {
                    System.out.println(ip + " is an unknown type.");
                }
            } catch (UnknownHostException e) {
                System.out.println("Error: Invalid IP address format - " + ip);
            }
        }
    }
}
