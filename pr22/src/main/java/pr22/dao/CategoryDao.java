package pr22.dao;

import pr22.entity.Category;

import java.util.List;

public interface CategoryDao extends GenericDao<Category, Integer>{
  
  public List<Category> findRoots();
  public Category loadWithChildren(int categoryId);
  
}
