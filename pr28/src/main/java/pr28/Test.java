package pr28;

import org.apache.openejb.core.LocalInitialContextFactory;

import javax.annotation.Resource;
import javax.ejb.embeddable.EJBContainer;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {

  @Resource
  private static ConnectionFactory factory;

  public static void main(String[] args) throws Exception {
    Logger.getLogger("").setLevel(Level.OFF);
    final Properties properties = new Properties();
    properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, LocalInitialContextFactory.class.getName());

    final EJBContainer container = EJBContainer.createEJBContainer(properties);
    Context ctx = new InitialContext();

    Client client = (Client)ctx.lookup("JmsClientLocal");

    System.out.println("\n==== QUEUE ====");
    client.sendToQueue();

    System.out.println("\n==== TOPIC CLIENT ====");
    client.sendToTopic();

    try { Thread.sleep(2000); } catch (Exception ex) { }
    container.close();
  }
}
