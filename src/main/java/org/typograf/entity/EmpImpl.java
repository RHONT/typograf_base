package org.typograf.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmpImpl implements EmployeeDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<Employee> getAllEmp() {
        Session session=sessionFactory.getCurrentSession();
        List<Employee> emp=session.createQuery("from Employee",Employee.class).getResultList();

        return emp;
    }
}
