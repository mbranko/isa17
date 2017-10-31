package pr22.dao;

import pr22.entity.PurchaseOrder;
import pr22.entity.User;

public interface UserDao extends GenericDao<User, Integer> {

  public User login(String username, String password);
  public PurchaseOrder add(User user, PurchaseOrder order);

}
