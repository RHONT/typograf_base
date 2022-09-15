package org.typograf.classImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.typograf.DAO.QualificationDAO;
import org.typograf.entity.Qualification;

import java.util.List;

@Repository
public class QualificationImpl  implements QualificationDAO {
    final
    SessionFactory sessionFactory;

    public QualificationImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Qualification> getAllQualities() {
        Session session= sessionFactory.getCurrentSession();
        return (List<Qualification>) session.createQuery("from Qualification").getResultList();
    }
}
