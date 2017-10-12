package pr03;

import java.math.BigDecimal;
import java.rmi.Naming;

public class ComputeClient {

  public static void main(String[] args) {
    setRmiCodebase();
    System.setSecurityManager(new SecurityManager());
    try {
      Compute comp = (Compute)Naming.lookup("//localhost:1099/Compute");
      Pi task = new Pi(100);
      BigDecimal pi = (BigDecimal)comp.executeTask(task);
      System.out.println(pi);
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
    
    String testFile = "/" + ComputeClient.class.getName().replace('.', '/') + ".class";
    String url = ComputeClient.class.getResource(testFile).toString();
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
