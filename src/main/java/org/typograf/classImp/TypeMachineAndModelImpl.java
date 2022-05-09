package org.typograf.classImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.typograf.DAO.TypeMachineAndModelDAO;
import org.typograf.entity.Machine;
import org.typograf.entity.SerialNumber;
import org.typograf.entity.TypeMachine;

import java.util.List;

@Repository
public class TypeMachineAndModelImpl implements TypeMachineAndModelDAO {
    @Autowired
    private SessionFactory sessionFactory;

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
        Machine machine=session.get(Machine.class,idMachine);
        return machine;
    }

    @Override
    public SerialNumber getSingleSerialNumber(String idSerialNumber) {
        Session session= sessionFactory.getCurrentSession();
        SerialNumber serialNumber=session.get(SerialNumber.class,idSerialNumber);
        return serialNumber;
    }

}

