package pr10.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pr10.model.Order;

@Component
public class PurchaseBean {

  @Autowired
  private PaymentBean payment;

  public boolean processOrder(Order order) {
    boolean paymentOK = payment.processCreditCard(order.getCreditCard());
    return paymentOK;
  }

}
