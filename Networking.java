import java.net.*; 
class Networking { 
    public static void main(String[] args) throws UnknownHostException { 
        InetAddress obj1 = InetAddress.getByName("myblog.com"); 
        InetAddress obj2 = InetAddress.getByName("www.myblog.com");
        boolean x = obj1.equals(obj2); 
        System.out.print("Both hostnames are equal:" +x); 
    }
}

