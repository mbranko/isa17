package pr08.purchase;

import pr08.model.Order;

public interface Purchase {
  public boolean processOrder(Order order);
}
