package pr10.beans;

import org.springframework.stereotype.Component;
import pr10.model.CreditCard;

@Component
public class PaymentBean {

  public boolean processCreditCard(CreditCard card) {
    return Math.random() < 0.5f;
  }

}
