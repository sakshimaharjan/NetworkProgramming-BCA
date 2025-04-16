import java.net.*;
   public class GuessContentType{
        public static void main(String[] args){
            String filename = "abc.jpg";
            String ContentType = URLConnection.guessContentTypeFromName(filename);
            // String filename1 = "hello world";
            // String ContentType = URLConnection.guessContentTypeFromStream(filename1);
            System.out.println("Content Type:" + ContentType);
        }
    }
