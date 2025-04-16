import java.io.IOException;
import java.net.*;
public class SocketInfo {
    public static void main(String[] args) {
        try{
            Socket toSoc = new Socket("www.example.com",80);
            System.out.println("Connected to " + toSoc.getInetAddress() + " on port " + toSoc.getPort() + " from port " + toSoc.getLocalPort() + " of " + toSoc.getLocalAddress());
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
}
