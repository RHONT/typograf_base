package org.typograf.classImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.typograf.DAO.WorkDAO;
import org.typograf.entity.Employee;
import org.typograf.entity.Machine;
import org.typograf.entity.Qualification;
import org.typograf.entity.Work;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@Transactional
public class WorkImpl implements WorkDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> GetListEmployee(Integer i, Integer j) {
        Session session = sessionFactory.getCurrentSession();

        TypedQuery query;
        query = session.createQuery("select new Employee(emp.id,emp.name,emp.surname,emp.email,emp.phone) " +
                "from Employee emp join Qualification q on emp.id=q.id.idEmployee " +
                "where q.id.idTypeMachine=:type and  q.qualification>=:qual");
        query.setParameter("type", j).setParameter("qual", i);
        List<Employee> list = query.getResultList();
            return list;
        }

    @Override
    public List getWorkTabelForOneEmp(int id) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery query;
        query=session.createQuery("from Work where idEmployee.id=:id").setParameter("id",id);
        List<Work> list=query.getResultList();
        return list;
    }

    @Override
    public List<Work> getOneTabelDay(Integer i, LocalDate localDate) {
        Session session = sessionFactory.getCurrentSession();

        TypedQuery query;
        query = session.createQuery("select new Work(Work .id,Work.dateVisit,Work.timeStart,Work .laidDownTime)from Work where idEmployee.id=:id_emp and dateVisit=:dv");
        query.setParameter("id_emp", i).setParameter("dv", localDate);
        List<Work> work= query.getResultList();

        return work;
    }
}
