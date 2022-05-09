package org.typograf.Services;

import org.typograf.entity.Employee;
import org.typograf.entity.Work;
import org.typograf.functionPack.EmployeeLinkedHashMap;

import java.time.LocalDate;
import java.util.List;

public interface DataBaseTypographService {
    List<Employee> getAllEmp();

    List<Employee> getListEmployeeForReportWork(Integer qualification, Integer idTypeMachine);
    List getWorkReportForOneEmp(int id_employee);
    List<Work> getOneReportDay(Integer id_employee, LocalDate selectDate);
    List<Work> getAllReportEmployees();
    List<EmployeeLinkedHashMap> fillWorkingCoverageOfDates(List<Employee> suitableEmployees, LocalDate wishDate);


}
