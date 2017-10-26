package pr11.purchase;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import pr11.model.Order;
import pr11.payment.PaymentLocal;

@Stateless(name="PurchaseBean")
@Remote(Purchase.class)
@Local(PurchaseLocal.class)
public class PurchaseBean implements Purchase {
  
  public boolean processOrder(Order order) {
    boolean paymentOK = payment.processCreditCard(order.getCreditCard());
    return paymentOK;
  }
  
  @EJB
  private PaymentLocal payment;
}
