package org.typograf.DAO;

import org.typograf.entity.Employee;


import java.util.List;

public interface WorkDAO {
    public List<Employee> GetListEmployee(Integer i,Integer j);
}
