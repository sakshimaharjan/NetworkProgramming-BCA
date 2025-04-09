package lab3;
import java.net.HttpURLConnection;
import java.net.URL;

public class CookieBlocker {
    public static void main(String[] args) {
        String website = "https://example.gov"; 

        if (website.endsWith(".gov")) {
            System.out.println("Cookies are blocked for: " + website);
        } else {
            System.out.println("Cookies are allowed for: " + website);
            sendRequest(website); 
        }
    }

    public static void sendRequest(String site) {
        try {
            URL url = new URL(site);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            // Allow cookies only for non-gov sites
            connection.setRequestProperty("Cookie", "user_session=123456");
            
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
