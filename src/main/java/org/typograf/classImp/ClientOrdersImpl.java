package org.typograf.classImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.typograf.DAO.ClientOrderDAO;

import java.util.List;

@Repository
public class ClientOrdersImpl implements ClientOrderDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<String> spisokTypeMachines() {
        Session session= sessionFactory.getCurrentSession();
        List<String> listSpisokTypeMachine=session.createQuery("select nameType from TypeMachine ").getResultList();
        return listSpisokTypeMachine;
    }

    @Transactional
    @Override
    public List<String> spisokModel() {
        Session session= sessionFactory.getCurrentSession();
        List<String> listSpisokModel=session.createQuery("select modelMachine from Machine ").getResultList();
        return listSpisokModel;
    }
}
