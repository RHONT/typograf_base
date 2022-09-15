package org.typograf.classImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.typograf.DAO.MapsForClientDAO;
import org.typograf.entity.Machine;
import org.typograf.entity.TypeMachine;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MapsForSelectImpl implements MapsForClientDAO {

    private final SessionFactory sessionFactory;

    public MapsForSelectImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Map<Integer, String> getListTypeMachines() {
        Session session= sessionFactory.getCurrentSession();
        List<TypeMachine> listBuffer=session.createQuery("from TypeMachine ").getResultList();
        return listBuffer.stream().collect(Collectors.toMap(TypeMachine::getId,TypeMachine::getNameType));
    }

    @Override
    public Map<Integer, String> getListMachines() {
        Session session= sessionFactory.getCurrentSession();
        List<Machine> listBuffer=session.createQuery("from Machine ").getResultList();
        return listBuffer.stream().collect(Collectors.toMap(Machine::getId,Machine::getModelMachine));
    }

    @Override
    public List<String> getSerialNumber() {
        Session session= sessionFactory.getCurrentSession();
        return (List<String>) session.createQuery("select id from SerialNumber").getResultList();
    }


}
