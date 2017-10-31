package pr22.session;

import pr22.entity.CreditCard;
import pr22.entity.PurchaseOrder;

public interface Purchase {
  
  public boolean processOrder(PurchaseOrder order, CreditCard card);

}
