package lab;

import java.net.*;

public class IPAddressTest {
    public static void main(String[] args) {
        // Define the IP addresses
        String ipv4Loopback = "127.0.0.1";
        String ipv6Loopback = "0::1";

        // Check characteristics of IPv4 loopback address
        checkIPAddressCharacteristics(ipv4Loopback);

        // Check characteristics of IPv6 loopback address
        checkIPAddressCharacteristics(ipv6Loopback);
    }

    public static void checkIPAddressCharacteristics(String ipAddress) {
        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddress);

            System.out.println("IP Address: " + ipAddress);

            if (inetAddress instanceof Inet4Address) {
                System.out.println("Type: IPv4");
            } else if (inetAddress instanceof Inet6Address) {
                System.out.println("Type: IPv6");
            }

            if (inetAddress.isLoopbackAddress()) {
                System.out.println("Address Type: Loopback");
            }

            // For IPv6, checking if it's Unicast
            if (inetAddress instanceof Inet6Address) {
                Inet6Address ipv6Address = (Inet6Address) inetAddress;
                if (ipv6Address.isSiteLocalAddress() || ipv6Address.isLinkLocalAddress()) {
                    System.out.println("IPv6 Address Type: Local");
                } else {
                    System.out.println("IPv6 Address Type: Global Unicast");
                }
            }

            System.out.println();
        } catch (UnknownHostException e) {
            System.out.println("Invalid IP address: " + ipAddress);
        }
    }
}
