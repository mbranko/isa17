package pr11.payment;

import pr11.model.CreditCard;

public interface Payment {
  public boolean processCreditCard(CreditCard card);
}