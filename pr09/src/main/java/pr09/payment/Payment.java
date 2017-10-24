package pr09.payment;

import pr09.model.CreditCard;

public interface Payment {
  boolean processCreditCard(CreditCard card);
}