// WAP to print the IP address of your machine
import java.net.*;
public class IP{
    public static void main(String[] args) throws UnknownHostException{
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr);
    }
}