package org.typograf.classImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.typograf.DAO.EmployeeDAO;
import org.typograf.entity.Employee;
import java.util.List;

@Repository
public class EmployeeImpl implements EmployeeDAO {
    private final SessionFactory sessionFactory;

    public EmployeeImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAllEmp() {
        Session session=sessionFactory.getCurrentSession();
        return session.createQuery("from Employee",Employee.class).getResultList();
    }

    @Override
    public Employee getSingleEmployee(Integer id_Employee) {
        Session session=sessionFactory.getCurrentSession();
        return session.get(Employee.class,id_Employee);
    }
}
