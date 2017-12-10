package pr24.bean;

import static javax.ejb.TransactionManagementType.BEAN;
import pr24.CreditCard;
import pr24.PurchaseOrder;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.transaction.UserTransaction;

@Stateless(name="Purchase24Bean")
@Remote(Purchase.class)
@Local(PurchaseLocal.class)
@TransactionManagement(BEAN)
public class PurchaseBean implements Purchase {
  
  @EJB
  private PaymentLocal payment;
  
  @Resource
  private UserTransaction tx;

  public boolean processOrder(PurchaseOrder order, CreditCard card) {
    try {
      tx.begin();
      boolean paymentOK = payment.processCreditCard(card);
      if (paymentOK)
        tx.commit();
      else
        tx.rollback();
      return paymentOK;
    } catch (Exception ex) {
      return false;
    }
  }
  
}
