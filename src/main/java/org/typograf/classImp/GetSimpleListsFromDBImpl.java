package org.typograf.classImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.typograf.DAO.ClientOrderDAO;
import org.typograf.entity.ClientRequest;
import org.typograf.entity.Machine;
import org.typograf.entity.SerialNumber;
import org.typograf.entity.TypeMachine;

import java.util.List;

@Repository
@Transactional
public class GetSimpleListsFromDBImpl implements ClientOrderDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<TypeMachine> getAllTypeMachines() {
        Session session= sessionFactory.getCurrentSession();
        return session.createQuery("from TypeMachine ").getResultList();
    }

    @Override
    public List<String> getAllModelName() {
        Session session= sessionFactory.getCurrentSession();
        return session.createQuery("select modelMachine from Machine ").getResultList();
    }

    @Override
    public TypeMachine getSingleTypeMachine(Integer numb) {
        Session session= sessionFactory.getCurrentSession();
        return session.get(TypeMachine.class,numb);
    }

    @Override
    public Machine getSingleMachine(Integer numb) {
        Session session= sessionFactory.getCurrentSession();
        Machine machine=session.get(Machine.class,numb);
        return machine;
    }

    @Override
    public SerialNumber getSingleSerialNumber(String str) {
        Session session= sessionFactory.getCurrentSession();
        SerialNumber serialNumber=session.get(SerialNumber.class,str);
        return serialNumber;
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
