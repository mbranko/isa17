package pr03;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Compute extends Remote {
  public Object executeTask(Task t) throws RemoteException;
}
