package ClientServerChat;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(8080);
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = " ", str2 = " ";
        while(str != "Stop"){
            System.out.println("Waiting for client reply");
            str = din.readUTF();
            System.out.println("Client: " + str);
            System.out.println("Enter msg: ");
            str2 = reader.readLine();
            dout.writeUTF(str2);
            dout.flush();
        }
        din.close();
        s.close();
        ss.close();
        
    }
}
