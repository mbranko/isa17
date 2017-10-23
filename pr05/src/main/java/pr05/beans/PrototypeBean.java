package pr05.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean {

  private int count = 0;

  public int getCount() {
    return ++count;
  }
}
