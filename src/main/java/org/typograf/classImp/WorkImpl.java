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
        query = session.createQuery("select new Employee(emp.name,emp.surname,emp.email,emp.phone) " +
                "from Employee emp join Qualification q on emp.id=q.id.idEmployee " +
                "where q.id.idTypeMachine=:type and  q.qualification>=:qual");
        query.setParameter("type", j).setParameter("qual", i);
        List<Employee> list = query.getResultList();


//        Query query= (Query) session.createSQLQuery(
//                "SELECT name,surname,email,phone " +
//                        "FROM employees join qualification on qualification.id_employee=employees.id_employee" +
//                " where qualification>:qual and id_type_machine=:type").setParameter("type",j).setParameter("qual",i).addEntity(Employee.class).list();
//        List<Employee> list= (List<Employee>) query;


//        List<Object> list=session.createQuery("select emp.id,emp.name,emp.surname,emp.email,emp.phone " +
//                "from Employee emp join Qualification q on emp.id=q.id.idEmployee " +
//                "where q.id.idTypeMachine=:type and  q.qualification>=:qual").setParameter("type",j).
//                setParameter("qual",i).getResultList();

            return list;
        }

}
