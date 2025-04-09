package lab2;

import java.net.URL;
import java.net.MalformedURLException;

public class URLParser {
    
    public static void parseURL(String urlString) {
        try {
            URL url = new URL(urlString);
            System.out.println("URL: " + urlString);
            System.out.println("Protocol (Scheme): " + url.getProtocol());
            System.out.println("User Info: " + url.getUserInfo());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("Reference: " + url.getRef());
            System.out.println("Query String: " + url.getQuery());
            System.out.println(new String(new char[40]).replace("\0", "-"));

        } catch (MalformedURLException e) {
            System.out.println("Invalid URL: " + urlString);
        }
    }

    public static void main(String[] args) {
        // Test the function with the given URLs
        String url1 = "http://www.example.com:80/index.html";
        String url2 = "ftp://mp3:mp3@138.247.121.61:21000/c%3a/";

        parseURL(url1);
        parseURL(url2);
    }
}

