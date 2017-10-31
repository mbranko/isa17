package pr22.dao;

import pr22.entity.Admin;

public interface AdminDao extends GenericDao<Admin, Integer> {

  public Admin login(String username, String password); 
  
}
