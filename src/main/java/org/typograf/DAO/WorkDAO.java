package org.typograf.DAO;

import org.typograf.entity.Employee;
import org.typograf.entity.Work;
import org.typograf.functionPack.EmployeeLinkedHashMap;


import java.time.LocalDate;
import java.util.List;

public interface WorkDAO {
    List<Employee> getEmployeesForReportWork(Integer qualification, Integer idTypeMachine);
    List getSingleWorkReportForEmp(int id_employee);
    List<Work> getSingleReportDay(Integer id_employee, LocalDate selectDate);
    Work getSingleReportDay(Integer id_work);
    List<Work> getAllReportEmployees();
    List<EmployeeLinkedHashMap> fillWorkingCoverageOfDates(List<Employee> suitableEmployees, LocalDate wishDate);

}
