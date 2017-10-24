package pr09.purchase;

import pr09.model.Order;

public interface Purchase {
  public boolean processOrder(Order order);
}
