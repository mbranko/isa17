package pr22.dao;

import pr22.entity.Product;

import java.util.List;

public interface ProductDao extends GenericDao<Product, Integer> {

  public List<Product> findProducts(int categoryId);
  
}
