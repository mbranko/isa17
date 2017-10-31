package pr22.dao;

import pr22.entity.ProductImage;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(ProductImageDao.class)
public class ProductImageDaoBean extends GenericDaoBean<ProductImage, Integer> implements ProductImageDao {

}
