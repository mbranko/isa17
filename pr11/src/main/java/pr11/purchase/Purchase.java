package pr11.purchase;

import pr11.model.Order;

public interface Purchase {
  public boolean processOrder(Order order);
}
