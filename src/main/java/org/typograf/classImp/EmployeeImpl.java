package org.typograf.classImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.typograf.DAO.EmployeeDAO;
import org.typograf.entity.Employee;

import java.util.List;

@Repository
public class EmployeeImpl implements EmployeeDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmp() {
        Session session=sessionFactory.getCurrentSession();
        List<Employee> emp=session.createQuery("from Employee",Employee.class).getResultList();
        return emp;
    }

    @Override
    public Employee getSingleEmployee(Integer id_Employee) {
        Session session=sessionFactory.getCurrentSession();
        return session.get(Employee.class,id_Employee);
    }
}
