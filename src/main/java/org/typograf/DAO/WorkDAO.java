package org.typograf.DAO;

import org.typograf.entity.Employee;
import org.typograf.entity.Work;
import org.typograf.functionPack.EmployeeLinkedHashMap;


import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;

public interface WorkDAO {
    public List<Employee> GetListEmployee(Integer i,Integer j);
    public List getWorkTabelForOneEmp(int id);
    public List<Work> getOneTabelDay(Integer i, LocalDate localDate);
    public List<Work> getAllTabel();
    public List<EmployeeLinkedHashMap> fillWorkingCoverageofDates(List<Employee> suitableEmployees,LocalDate wishDate);

}
