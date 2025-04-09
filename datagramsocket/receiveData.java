package datagramsocket;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class receiveData {
    public static void main(String[] args) throws Exception{
        DatagramSocket dsoc = new DatagramSocket(3000);
        byte[] buf = new byte[3000];
        DatagramPacket dpac = new DatagramPacket(buf, 3000);
        dsoc.receive(dpac);
        String str = new String(dpac.getData(),0,dpac.getLength());
        System.out.println(str);
        dsoc.close();
    }
}
