import java.net.Socket;
import java.io.IOException;

public class LowPortScanner {
    public static void main(String[] args) {
        String host = args.length > 0 ? args[0] : "localhost";

        for (int i = 1; i <= 1024; i++) {
            try (Socket s = new Socket(host, i)) {
                System.out.println("Port " + i + " is open on " + host);
            } catch (IOException ignored) {
                // Do nothing for closed ports
            }
        }
    }
}
