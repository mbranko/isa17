package pr28.topic;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class NewsClient {
  public static void main(String[] args) {
    System.setProperty(Context.INITIAL_CONTEXT_FACTORY, 
      "org.ow2.easybeans.component.smartclient.spi.SmartContextFactory");
    System.setProperty(Context.PROVIDER_URL, 
      "smart://localhost:2503");
    
    try {
      Context ctx = new InitialContext();
      TopicConnectionFactory factory = (TopicConnectionFactory)ctx.lookup("JTCF");
      Topic topic = (Topic)ctx.lookup("NewsTopic");
      TopicConnection conn = factory.createTopicConnection();
      TopicSession session = conn.createTopicSession(false, 
          Session.AUTO_ACKNOWLEDGE);
      TopicPublisher publisher = session.createPublisher(topic);
      
      ObjectMessage objMsg = session.createObjectMessage();
      objMsg.setObject(new NewsMessage("Poskupelo ulje", "Ulje je poskupelo za jos 350%..."));
      publisher.send(objMsg);
      ObjectMessage objMsg2 = session.createObjectMessage();
      objMsg2.setObject(new NewsMessage("Poskupelo gorivo", "Benzin je poskupeo za jos 850%..."));
      publisher.send(objMsg2);
      
      publisher.close();
      session.close();
      conn.close();
    } catch (NamingException ex) {
      ex.printStackTrace();
    } catch (JMSException ex) {
      ex.printStackTrace();
    }
  }

}
