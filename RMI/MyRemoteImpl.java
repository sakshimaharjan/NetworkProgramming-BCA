import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject;       

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {  
    protected MyRemoteImpl() throws RemoteException {  
       
        super();
    }

    @Override
    public String sayHello() throws RemoteException {  
        // Override the sayHello method from the MyRemote interface, which throws a RemoteException.
        // This method returns the string "Hello, World!" when invoked remotely.
        return "Hello, World!";
    }

    public static void main(String[] args) {  
        // Main method to start the server and bind the remote object to the RMI registry.
        try {
            MyRemoteImpl obj = new MyRemoteImpl();  
            // Create an instance of MyRemoteImpl, which automatically exports the object.

            java.rmi.Naming.rebind("rmi://localhost/MyRemote", obj);  
            // Bind the remote object to the RMI registry with the name "MyRemote" at the specified URL.
            // This allows clients to look up and invoke methods on the remote object.

            System.out.println("Server is ready.");  
            // Print a message to indicate that the server is ready to accept remote method calls.
        } catch (Exception e) {
            System.out.println("Server failed: " + e);  
            // If an exception occurs, print an error message with the exception details.
        }
    }
}
