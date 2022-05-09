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
    public List<TypeMachine> spisokTypeMachines() {
        Session session= sessionFactory.getCurrentSession();
        List<TypeMachine> listSpisokTypeMachine=session.createQuery("from TypeMachine ").getResultList();
        return listSpisokTypeMachine;
    }


    @Override
    public List<String> getAllModel() {
        Session session= sessionFactory.getCurrentSession();
        List<String> listSpisokModel=session.createQuery("select modelMachine from Machine ").getResultList();
        return listSpisokModel;
    }

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
    public TypeMachine getTypeMachine(Integer numb) {
        Session session= sessionFactory.getCurrentSession();
        return session.get(TypeMachine.class,numb);
    }

    @Override
    public Machine getMachine(Integer numb) {
        Session session= sessionFactory.getCurrentSession();
        Machine machine=session.get(Machine.class,numb);
        return machine;
    }

    @Override
    public SerialNumber getSerialNumber(String str) {
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
    public ClientRequest getOneClientRequest(Integer idClientRequest) {
        Session session= sessionFactory.getCurrentSession();
        return session.get(ClientRequest.class,idClientRequest);
    }
}
