package pr22.dao;

import pr22.entity.Supplier;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(SupplierDao.class)
public class SupplierDaoBean extends GenericDaoBean<Supplier, Integer> implements SupplierDao {

}
