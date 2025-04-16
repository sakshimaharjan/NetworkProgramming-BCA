import java.rmi.Remote; 
/* Import the Remote interface from the java.rmi package that is  being accessible remotely via RMI */
import java.rmi.RemoteException; /*RemoteException is thrown when a remote method invocation fails*/

public interface MyRemote extends Remote {
    String sayHello() throws RemoteException; 
}
