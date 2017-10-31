package pr22.session;

import pr22.entity.CreditCard;

public interface Payment {

  public boolean processCreditCard(CreditCard card);
  
}
