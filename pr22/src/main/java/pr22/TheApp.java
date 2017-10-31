package pr22;

import org.apache.openejb.testing.Application;
import org.apache.openejb.testng.PropertiesBuilder;
import org.apache.tomee.embedded.TomEEEmbeddedApplicationRunner;

import java.util.Properties;

@Application
public class TheApp {

  public static void main(String[] args) throws Exception {
    TomEEEmbeddedApplicationRunner.run(TheApp.class);
  }
}