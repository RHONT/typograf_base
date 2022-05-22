package org.typograf.classImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.typograf.DAO.CompletedOrderDAO;
import org.typograf.entity.CompletedOrder;

import java.util.List;


@Repository
@Transactional
public class CompletedOrderImpl implements CompletedOrderDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CompletedOrder getSingleCompletedOrder(Integer id_CompletedOrder) {
        Session session=sessionFactory.getCurrentSession();
        CompletedOrder completedOrder=session.get(CompletedOrder.class,id_CompletedOrder);
        return completedOrder;
    }

    @Override
    public List<CompletedOrder> getAllCompletedOrder() {
        Session session=sessionFactory.getCurrentSession();
        List<CompletedOrder> completedOrders=session.createQuery("from CompletedOrder").getResultList();
        return completedOrders;
    }
}
