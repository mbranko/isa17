package pr13.count;

import org.springframework.stereotype.Component;
import pr13.logger.Loggable;
import pr13.transaction.Transactable;

@Component
public class CountBean {

  private int count = 0;

  @Loggable
  public int count() {
    System.out.println("[CountBean] Incrementing counter to: " + (++count));
    return count;
  }

  @Transactable
  public int store() {
    System.out.println("[CountBean] storing counter value: " + count);
    return count;
  }
}
