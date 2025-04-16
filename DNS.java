//wap to convert dotted quad address(8.8.8.8) into a hostname using gettermethod
//localmachineIP -> getHostAddress()
// host name of given IP address(127.0.0.1) -> InetAddress.getByName("127.0.0.1"); getCannonicalHostName();
import java.net.*;

public class DNS{
    public static void main(String[] args) throws UnknownHostException{
        // InetAddress ia = InetAddress.getByName("8.8.4.4");
        // System.out.println(ia.getCanonicalHostName());
        InetAddress ia = InetAddress.getByName("127.0.0.1");
        System.out.println(ia.getCanonicalHostName());
    }
}