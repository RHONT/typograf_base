package org.typograf.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.typograf.DAO.EmployeeDAO;
import org.typograf.DAO.WorkDAO;
import org.typograf.entity.Employee;
import org.typograf.entity.Work;
import org.typograf.functionPack.EmployeeLinkedHashMap;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class DataBaseTypographServiceImpl implements DataBaseTypographService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private WorkDAO workDAO;

    @Override
    public List<Employee> getAllEmp() {
        return employeeDAO.getAllEmp();
    }


    @Override
    public List<Employee> getListEmployeeForReportWork(Integer qualification, Integer idTypeMachine) {
        return workDAO.getEmployeesForReportWork(qualification,idTypeMachine);
    }

    @Override
    public List getWorkReportForOneEmp(int id_employee) {
        return workDAO.getSingleWorkReportForEmp(id_employee);
    }

    @Override
    public List<Work> getOneReportDay(Integer id_employee, LocalDate selectDate) {
        return workDAO.getSingleReportDay(id_employee,selectDate);
    }

    @Override
    public List<Work> getAllReportEmployees() {
        return workDAO.getAllReportEmployees();
    }

    @Override
    public List<EmployeeLinkedHashMap> fillWorkingCoverageOfDates(List<Employee> suitableEmployees, LocalDate wishDate) {
        return workDAO.fillWorkingCoverageOfDates(suitableEmployees, wishDate);
    }
}
