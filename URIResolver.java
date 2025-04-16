import java.net.URI;
import java.net.URISyntaxException;
public class URIResolver {
    public static void main(String[] args) {
        String baseURIString = "https://www.example.com/base"; 
        String relativeURIString = "/path/to/resource"; 
        try {
            URI baseURI = new URI(baseURIString); 
            URI relativeURI = new URI(relativeURIString); 
            URI absoluteURI = baseURI.resolve(relativeURI); 
            String resolvedURIString = absoluteURI.toString(); 
            System.out.println("Resolved URI: " + resolvedURIString); 
        } catch (URISyntaxException e) {
            System.err.println("Error resolving URI: " + e.getMessage()); 
        }
    }
}