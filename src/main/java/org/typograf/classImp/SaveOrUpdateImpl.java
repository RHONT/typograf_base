package org.typograf.classImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.typograf.DAO.SaveOrUpdateDAO;
import org.typograf.entity.ClientRequest;
import org.typograf.entity.TypeMachine;

@Repository
public class SaveOrUpdateImpl implements SaveOrUpdateDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveClientRequest(ClientRequest clientRequest) {
        Session session= sessionFactory.getCurrentSession();
        session.save(clientRequest);
    }

    @Override
    public void updateClientRequest(ClientRequest clientRequest) {
        Session session= sessionFactory.getCurrentSession();
        session.saveOrUpdate(clientRequest);
    }

    @Override
    public void saveTypeMachine(TypeMachine typeMachine) {
        Session session=sessionFactory.getCurrentSession();
        session.save(typeMachine);
    }
}
