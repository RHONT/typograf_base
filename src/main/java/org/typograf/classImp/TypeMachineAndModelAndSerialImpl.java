package org.typograf.classImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.typograf.DAO.TypeMachineAndModelDAO;
import org.typograf.entity.Machine;
import org.typograf.entity.SerialNumber;
import org.typograf.entity.TypeMachine;
import java.util.List;

@Repository
public class TypeMachineAndModelAndSerialImpl implements TypeMachineAndModelDAO {
    private final SessionFactory sessionFactory;

    public TypeMachineAndModelAndSerialImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<TypeMachine> getAllTypeMachines() {
        Session session= sessionFactory.getCurrentSession();
        return session.createQuery("from TypeMachine ").getResultList();
    }

    @Override
    public TypeMachine getSingleTypeMachine(Integer idTypeMachine) {
        Session session= sessionFactory.getCurrentSession();
        return session.get(TypeMachine.class,idTypeMachine);
    }

    @Override
    public List<String> getAllModelName() {
        Session session= sessionFactory.getCurrentSession();
        return session.createQuery("select modelMachine from Machine ").getResultList();
    }

    @Override
    public Machine getSingleMachine(Integer idMachine) {
        Session session= sessionFactory.getCurrentSession();
        return session.get(Machine.class,idMachine);
    }

    @Override
    public SerialNumber getSingleSerialNumber(String idSerialNumber) {
        Session session= sessionFactory.getCurrentSession();
        return session.get(SerialNumber.class,idSerialNumber);
    }

}

