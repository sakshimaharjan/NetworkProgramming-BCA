package ClientServerChat;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("localhost", 8080);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = " ", str2 = " ";
        while(str != "Stop"){
            System.out.println("Enter response: ");
            str = reader.readLine();
            dout.writeUTF(str);
            dout.flush();
            System.out.println("Waiting for server reply: ");
            str2 = din.readUTF();
            System.out.println("Server says: " + str2); 
        }
        dout.close();
        s.close();
    }
}
