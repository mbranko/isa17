package pr22.dao;

import pr22.entity.PurchaseOrder;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(PurchaseOrderDao.class)
public class PurchaseOrderDaoBean extends GenericDaoBean<PurchaseOrder, Integer> implements PurchaseOrderDao {

}
