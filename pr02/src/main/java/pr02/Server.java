package pr02;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Server extends UnicastRemoteObject implements ServerI {

  public Server() throws RemoteException {
  }

  public int count() {
    return ++count;
  }

  private int count = 0;
  
  private static final long serialVersionUID = 8423253694594477374L;
}