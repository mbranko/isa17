package pr28.queue;

import java.math.BigDecimal;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class PaymentClient {
  
  public static void main(String[] args) {
    System.setProperty(Context.INITIAL_CONTEXT_FACTORY, 
      "org.ow2.easybeans.component.smartclient.spi.SmartContextFactory");
    System.setProperty(Context.PROVIDER_URL, 
      "smart://localhost:2503");
    
    try {
      Context ctx = new InitialContext();
      QueueConnectionFactory factory = (QueueConnectionFactory)ctx.lookup("JQCF");
      Queue queue = (Queue)ctx.lookup("PaymentQueue");
      QueueConnection conn = factory.createQueueConnection();
      QueueSession session = conn.createQueueSession(false, 
          Session.AUTO_ACKNOWLEDGE);
      QueueSender sender = session.createSender(queue);
      
      ObjectMessage objMsg = session.createObjectMessage();
      objMsg.setObject(new PaymentInfo(CardType.VISA, "111111111", "2008/12", 
          new BigDecimal("1350.32")));
      sender.send(objMsg);
      ObjectMessage objMsg2 = session.createObjectMessage();
      objMsg2.setObject(new PaymentInfo(CardType.VISA, "22222222", "2008/12", 
          new BigDecimal("5324.33")));
      sender.send(objMsg2);
      
      sender.close();
      session.close();
      conn.close();
    } catch (NamingException ex) {
      ex.printStackTrace();
    } catch (JMSException ex) {
      ex.printStackTrace();
    }
  }
}
