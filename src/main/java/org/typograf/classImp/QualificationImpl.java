package org.typograf.classImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.typograf.DAO.QualificationDAO;
import org.typograf.entity.Qualification;

import java.util.List;

@Repository
public class QualificationImpl  implements QualificationDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<Qualification> getQuality() {
        Session session= sessionFactory.getCurrentSession();
        return (List<Qualification>) session.createQuery("from Qualification").getResultList();
    }
}
