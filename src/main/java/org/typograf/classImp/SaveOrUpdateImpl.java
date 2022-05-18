package org.typograf.classImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.typograf.DAO.SaveOrUpdateDAO;
import org.typograf.entity.ClientRequest;
import org.typograf.entity.Employee;
import org.typograf.entity.TypeMachine;
import org.typograf.entity.Work;

import java.time.LocalDate;

@Repository
public class SaveOrUpdateImpl implements SaveOrUpdateDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveClientRequest(ClientRequest clientRequest) {
        Session session= sessionFactory.getCurrentSession();
        session.save(clientRequest);
    }

    @Override
    public void updateClientRequest(ClientRequest clientRequest) {
        Session session= sessionFactory.getCurrentSession();
        session.saveOrUpdate(clientRequest);
    }

    @Override
    public void saveTypeMachine(TypeMachine typeMachine) {
        Session session=sessionFactory.getCurrentSession();
        session.save(typeMachine);
    }

    @Override
    public void saveWork(Work work, Integer id_employee, Integer id_clientRequest, LocalDate dateWork, Integer timeForecast) {
        Session session=sessionFactory.getCurrentSession();
        Employee employee=session.get(Employee.class,id_employee);
        ClientRequest clientRequest=session.get(ClientRequest.class,id_clientRequest);
        employee.addWork(work);
        work.setIdClientRequest(clientRequest);
        work.setDateVisit(dateWork);
        work.setLaidDownTime(timeForecast);
        session.save(work);
    }
}
