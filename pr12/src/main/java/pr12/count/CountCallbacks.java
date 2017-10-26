package pr12.count;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.interceptor.InvocationContext;

public class CountCallbacks {

  @PostConstruct
  public void construct(InvocationContext ctx) {
    System.out.println("[CountCallbacks] @PostConstruct");
  }
  
  @PreDestroy
  public void destroy(InvocationContext ctx) {
    System.out.println("[CountCallbacks] @PreDestroy");
  }

  @PostActivate
  public void activate(InvocationContext ctx) {
    System.out.println("[CountCallbacks] @PostActivate");
  }
  
  @PrePassivate
  public void passivate(InvocationContext ctx) {
    System.out.println("[CountCallbacks] @PrePassivate");
  }
}