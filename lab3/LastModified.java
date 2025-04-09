package lab3;

import java.io.*;
import java.net.*;
import java.util.*;
public class LastModified {
public static void main(String[] args) throws UnknownHostException, IOException {
URL u = new URL( "http://scst.edu.np/uploads/content_image/BCA_Course_Structure.png");
// Put any URL that point to the file and check that file modified date
HttpURLConnection http = (HttpURLConnection) u.openConnection();
http.setRequestMethod("HEAD");
System.out.println(u + " was last modified at " + new Date(http.getLastModified()));
}
}