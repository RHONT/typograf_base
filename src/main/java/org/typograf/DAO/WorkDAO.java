package org.typograf.DAO;

import org.typograf.entity.Employee;
import org.typograf.entity.Work;


import java.time.LocalDate;
import java.util.List;

public interface WorkDAO {
    public List<Employee> GetListEmployee(Integer i,Integer j);
    public List getWorkTabelForOneEmp(int id);
    public List<Work> getOneTabelDay(Integer i, LocalDate localDate);
    public List<Work> getAllTabel();

}
