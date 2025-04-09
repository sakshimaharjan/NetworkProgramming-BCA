package lab2;

import java.net.URL;
import java.net.MalformedURLException;

public class URLComparison {

    public static void main(String[] args) {
        try {
            String url1 = "www.ibiblio.org";
            String url2 = "helios.ibiblio.org";
            String url3 = "http://www.ibiblio.org/";
            String url4 = "http://ibiblio.org/";

            // Create URL objects
            URL u1 = new URL("http://" + url1); // Add "http://" to ensure it works as a URL
            URL u2 = new URL("http://" + url2); // Add "http://" to ensure it works as a URL
            URL u3 = new URL(url3);
            URL u4 = new URL(url4);

            // Compare hostnames
            System.out.println("Comparing hostnames of '" + url1 + "' and '" + url2 + "': " + u1.getHost().equals(u2.getHost()));
            System.out.println("Comparing hostnames of '" + url3 + "' and '" + url4 + "': " + u3.getHost().equals(u4.getHost()));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
