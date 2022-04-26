package org.typograf.classImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.typograf.DAO.TypeMachineDAO;
import org.typograf.entity.TypeMachine;

import java.util.List;
import java.util.Set;

@Repository
public class TypeMachineImpl  implements TypeMachineDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<TypeMachine> showAllTypeMachines() {
        Session session=sessionFactory.getCurrentSession();
        List<TypeMachine> list= session.createQuery("from TypeMachine").getResultList();
        return list;
    }

//    @Transactional
//    @Override
//    public List<String> spisokMachines() {
//        Session session=sessionFactory.getCurrentSession();
//        return (List<String>) session.createQuery("select nameType from TypeMachine").getResultList();
//    }

}

