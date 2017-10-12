package pr02;

import java.rmi.Naming;

public class ServerMain {

  public static void main(String[] args) {
    try {
      setRmiCodebase();
      Server server = new Server();      
      Naming.rebind("ServerObject", server);
      
      // ko ne zeli da nasledi UnicastRemoteObject moze to ovako da uradi:
      // Server server = new Server();
      // ServerI stub = (ServerI)UnicastRemoteObject.exportObject(server, 0);
      // Naming.rebind("ServerObject", stub);
      
      System.out.println("Server started.");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  
  /**
   * RMI registry mora da zna gde ce pronaci klase koje cine server. Ta lokacija
   * se definise sistemskim propertijem pod nazivom java.rmi.server.codebase.
   * Serverski program se moze pozvati tako da se ovaj properti definise u
   * komandnoj liniji:
   * 
   * java -Djava.rmi.server.codebase=file://path-to-dir-or-jar class-name
   * 
   * Ako se kao lokacija navodi direktorijum, putanja se mora zavrsiti kosom 
   * crtom (/).
   * 
   * Ova metoda sluzi da definise properti ako on nije definisan prilikom poziva
   * programa iz komandne linije. Pri tome se gleda da li se program pokrece iz
   * jar fajla ili je raspakovan u fajl sistemu.
   */
  private static void setRmiCodebase() {
    String codebase = System.getProperty("java.rmi.server.codebase");
    if (codebase != null)
      return;
    
    String testFile = "/" + ServerMain.class.getName().replace('.', '/') + ".class";
    String url = ServerMain.class.getResource(testFile).toString();
    if (url.startsWith("jar:")) {
      int pos = url.indexOf(".jar");
      codebase = "file://" + url.substring(9, pos + 4);
    } else if (url.startsWith("file:")) {
      int pos = url.indexOf("bin");
      codebase = "file://" + url.substring(5, pos+4);
    } else // WTF
      return;
    System.err.println("Setting RMI codebase to " + codebase);
    System.setProperty("java.rmi.server.codebase", codebase);
    System.setProperty("java.rmi.server.useCodebaseOnly", "true");
  }
}
