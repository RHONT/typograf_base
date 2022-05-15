package org.typograf.classImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.typograf.DAO.MapsForClientDAO;
import org.typograf.entity.Machine;
import org.typograf.entity.SerialNumber;
import org.typograf.entity.TypeMachine;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class MapsForSelectImpl implements MapsForClientDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Map<Integer, String> getListTypeMachines() {
        Session session= sessionFactory.getCurrentSession();
        List<TypeMachine> listBuffer=session.createQuery("from TypeMachine ").getResultList();
        Map<Integer,String> mapBuffer=
                listBuffer.stream().collect(Collectors.toMap(TypeMachine::getId,TypeMachine::getNameType));
        return mapBuffer;
    }

    @Override
    public Map<Integer, String> getListMachines() {
        Session session= sessionFactory.getCurrentSession();
        List<Machine> listBuffer=session.createQuery("from Machine ").getResultList();
        Map<Integer,String> mapBuffer=
                listBuffer.stream().collect(Collectors.toMap(Machine::getId,Machine::getModelMachine));
        return mapBuffer;
    }

    @Override
    public List<String> getSerialNumber() {
        Session session= sessionFactory.getCurrentSession();
        List<String> listbuffer=session.createQuery("select id from SerialNumber").getResultList();

        return listbuffer;
    }


}
