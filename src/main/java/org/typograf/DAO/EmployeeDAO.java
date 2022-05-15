package org.typograf.DAO;

import org.typograf.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmp();
    Employee getSingleEmployee(Integer id_Employee);
}
