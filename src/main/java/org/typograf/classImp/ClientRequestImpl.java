package org.typograf.classImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.typograf.DAO.ClientOrderDAO;
import org.typograf.entity.ClientRequest;


import java.util.List;

@Repository
public class ClientRequestImpl implements ClientOrderDAO {
    private final SessionFactory sessionFactory;

    public ClientRequestImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<ClientRequest> getAllClientRequest() {
        Session session= sessionFactory.getCurrentSession();
        return session.createQuery("from ClientRequest").getResultList();
    }

    @Override
    public ClientRequest getSingleClientRequest(Integer idClientRequest) {
        Session session= sessionFactory.getCurrentSession();
        return session.get(ClientRequest.class,idClientRequest);
    }
}
