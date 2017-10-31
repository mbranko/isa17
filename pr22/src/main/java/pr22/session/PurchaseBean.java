package pr22.session;

import pr22.entity.CreditCard;
import pr22.entity.PurchaseOrder;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
@Remote(Purchase.class)
@Local(PurchaseLocal.class)
public class PurchaseBean implements Purchase {
  
  @Interceptors(Logger.class)
  public boolean processOrder(PurchaseOrder order, CreditCard card) {
    boolean paymentOK = payment.processCreditCard(card);
    return paymentOK;
  }
  
  @EJB
  private PaymentLocal payment;
}
