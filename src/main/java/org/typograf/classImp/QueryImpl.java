package org.typograf.classImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class QueryImpl implements RandomQuery {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public String getMyQuery() {
        String answer;
        List ss;


        Session session= sessionFactory.getCurrentSession();
        ss=session.createQuery("select Employee.name from Employee where Employee .id=2").getResultList();
        return ss.toString();
    }
}
