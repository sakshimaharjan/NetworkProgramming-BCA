import java.rmi.Naming; 
// The Naming class provides methods for storing and obtaining references to remote objects in the RMI registry.

public class MyClient {  
// This class will act as the client that looks up the remote object and invokes its methods.

    public static void main(String[] args) {  // Main method, the entry point for the Java application.
        try {  
            // Try block to handle potential exceptions that may occur during the lookup and invocation of remote methods.

            MyRemote stub = (MyRemote) Naming.lookup("rmi://localhost/MyRemote");  
            // Lookup the remote object in the RMI registry using the Naming.lookup() method.
            // The URL "rmi://localhost/MyRemote" specifies the location and name of the remote object.
            // The returned object is cast to the MyRemote interface type.

            String response = stub.sayHello();  
            // Invoke the sayHello() method on the remote object using the stub.
            // The result of the method call is stored in the variable 'response'.

            System.out.println("Response: " + response);  
            // Print the response received from the remote method call to the console.

        } catch (Exception e) {  
            // Catch block to handle any exceptions that may occur during the lookup or invocation.
            System.out.println("Client failed: " + e);  
            // If an exception occurs, print an error message with the exception details.
        }
    }
}
