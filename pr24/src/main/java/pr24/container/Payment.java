package pr24.container;

import pr24.CreditCard;

public interface Payment {

  public boolean processCreditCard(CreditCard card) throws MyException;
  
}
