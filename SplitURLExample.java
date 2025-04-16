import java.net.URL;
public class SplitURLExample {
public static void main(String[] args) {
    try {
        URL url = new URL("https://www.example.com:443/anything/thispage.html?param1=value1#here");
        
        System.out.println("Protocol: " +url.getProtocol());
       
        System.out.println("Host: " + url.getHost());
        
        System.out.println("Port: " + url.getPort());
        
        System.out.println("Path: " + url.getPath());
        
        System.out.println("Query: " + url.getQuery());
        
        System.out.println("Fragment: " + url.getRef());
  
    } catch (Exception e) {
        e.printStackTrace();
        }
    }
}