package org.typograf.classImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.typograf.DAO.CompletedOrderDAO;
import org.typograf.entity.CompletedOrder;

import javax.persistence.NoResultException;
import java.util.List;


@Repository
@Transactional
public class CompletedOrderImpl implements CompletedOrderDAO {

    private final SessionFactory sessionFactory;

    public CompletedOrderImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public CompletedOrder getSingleCompletedOrder(Integer id_CompletedOrder) {
        Session session=sessionFactory.getCurrentSession();
        return session.get(CompletedOrder.class,id_CompletedOrder);
    }

    @Override
    public CompletedOrder getSingleCompletedOrder(Integer id_clientRequest, Integer id_employee) {
        Session session=sessionFactory.getCurrentSession();
        CompletedOrder completedOrder=null;
        try {
            completedOrder= (CompletedOrder) session.createQuery
                            ("from CompletedOrder where idClientRequest.id=:id_clientRequest and idEmployee.id=:id_employee").
                    setParameter("id_clientRequest",id_clientRequest).setParameter("id_employee",id_employee).getSingleResult();
        } catch (NoResultException e){
            // исключение нам обрабатывать и не нужно.
        }
        if (completedOrder==null) return new CompletedOrder();

        return completedOrder;
    }

    @Override
    public List<CompletedOrder> getAllCompletedOrder() {
        Session session=sessionFactory.getCurrentSession();
        return (List<CompletedOrder>) session.createQuery("from CompletedOrder").getResultList();
    }
}
