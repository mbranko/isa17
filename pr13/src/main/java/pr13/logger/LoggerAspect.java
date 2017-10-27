package pr13.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

  @Before("@annotation(pr13.logger.Loggable)")
  public void logBefore(JoinPoint joinPoint) {
    System.out.println("[LoggerAspect] Logging before running method: " + joinPoint.getSignature() + " on object " + joinPoint.getTarget());
  }

  @After("@annotation(pr13.logger.Loggable)")
  public void logAfter(JoinPoint joinPoint) {
    System.out.println("[LoggerAspect] Logging after running method");
  }
}
