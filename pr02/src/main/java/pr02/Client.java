package pr02;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
  public static void main(String[] args) {
    try {
      System.out.println("Connecting to server...");
      Registry registry = LocateRegistry.getRegistry("localhost");
      ServerI stub = (ServerI)registry.lookup("ServerObject");
      System.out.println("Count: " + stub.count());
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

}