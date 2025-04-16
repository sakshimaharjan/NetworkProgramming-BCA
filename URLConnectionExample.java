import java.net.*;
import java.io.*;

public class URLConnectionExample {
public static void main(String[] args) {
try {

URL url = new URL("https://www.example.com");

URLConnection urlConnection = url.openConnection();

InputStream inputStream = urlConnection.getInputStream();

BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

String inputLine; 

while ((inputLine = reader.readLine()) != null)
{
System.out.println(inputLine); 
}

reader.close();
} catch (IOException e) {
}
}
}