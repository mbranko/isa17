package pr08.payment;

import pr08.model.CreditCard;

public interface Payment {
  boolean processCreditCard(CreditCard card);
}