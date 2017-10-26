package pr12.count;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.interceptor.Interceptors;

@Stateful(name="CountBean")
@Remote(Count.class)
@Local(CountLocal.class)
@Interceptors(CountCallbacks.class)
public class CountBean implements Count {
  
  private int value = 0;

  public int count() {
    return ++value;
  }
  
  public void set(int value) {
    this.value = value;
  }
  
  @Remove
  public void remove() {
    System.out.println("[CountBean] remove()");
  }
  
}

