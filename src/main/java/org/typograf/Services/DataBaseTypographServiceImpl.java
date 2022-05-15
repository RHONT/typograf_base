package org.typograf.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.typograf.DAO.*;
import org.typograf.entity.*;
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

    @Autowired
    private TypeMachineAndModelDAO typeMachineDAO;

    @Autowired
    private ClientOrderDAO clientOrderDAO;

    @Autowired
    private QualificationDAO qualificationDAO;

    @Override
    public List<Employee> getAllEmp() {
        return employeeDAO.getAllEmp();
    }

    @Override
    public Employee getSingleEmployee(Integer id_Employee) {
        return employeeDAO.getSingleEmployee(id_Employee);
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

    @Override
    public List<TypeMachine> getAllTypeMachines() {
        return typeMachineDAO.getAllTypeMachines();
    }

    @Override
    public TypeMachine getSingleTypeMachine(Integer idTypeMachine) {
        return typeMachineDAO.getSingleTypeMachine(idTypeMachine);
    }

    @Override
    public List<String> getAllModelName() {
        return typeMachineDAO.getAllModelName();
    }

    @Override
    public Machine getSingleMachine(Integer idMachine) {
        return typeMachineDAO.getSingleMachine(idMachine);
    }

    @Override
    public SerialNumber getSingleSerialNumber(String idSerialNumber) {
        return typeMachineDAO.getSingleSerialNumber(idSerialNumber);
    }

    @Override
    public List<ClientRequest> getAllClientRequest() {
        return clientOrderDAO.getAllClientRequest();
    }

    @Override
    public ClientRequest getSingleClientRequest(Integer idClientRequest) {
        return clientOrderDAO.getSingleClientRequest(idClientRequest);
    }

    @Override
    public List<Qualification> getAllQualities() {
        return qualificationDAO.getAllQualities();
    }
}
