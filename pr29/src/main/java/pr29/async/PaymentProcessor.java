package pr29.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import pr29.message.PaymentInfo;

import java.util.concurrent.Future;

@Component
public class PaymentProcessor {

  @Async
  public void processPaymentOne(PaymentInfo paymentInfo) {
    System.out.println("[PaymentProcessor.processPaymentOne]: " + paymentInfo);
  }

  @Async
  public Future<String> processPaymentTwo(PaymentInfo paymentInfo) {
    System.out.println("[PaymentProcessor.processPaymentTwo]: " + paymentInfo);
    return new AsyncResult<>("DEMO RESULT");
  }

}
