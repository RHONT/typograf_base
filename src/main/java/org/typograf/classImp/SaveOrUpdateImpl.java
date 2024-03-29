package org.typograf.classImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.typograf.DAO.SaveOrUpdateDAO;
import org.typograf.entity.*;

import java.time.LocalDate;

@Repository
public class SaveOrUpdateImpl implements SaveOrUpdateDAO {

    private static final Logger log= LoggerFactory.getLogger(SaveOrUpdateImpl.class);

    final SessionFactory sessionFactory;

    public SaveOrUpdateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveClientRequest(ClientRequest clientRequest) {
        Session session= sessionFactory.getCurrentSession();
        session.save(clientRequest);
        log.info("Объект clientRequest сохранен");
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

        if (clientRequest.getDataWish().equals(dateWork)){
            work.setIdClientRequest(clientRequest);
        }
        else
        {
            clientRequest.setDataWish(dateWork);
            work.setIdClientRequest(clientRequest);
        }
        employee.addWork(work);

        work.setDateVisit(dateWork);
        work.setLaidDownTime(timeForecast);
        session.save(work);
    }

    @Override
    public void saveOrUpdateCompletedOrder(CompletedOrder completedOrder) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(completedOrder);
    }

    @Override
    public void saveOrUpdateCompletedOrder(CompletedOrder completedOrder,
                                           Integer idClientRequest,
                                           Integer idEmployee,
                                           Integer idMachine,
                                           Integer idTypeMachine,
                                           String idSerialNumber) {

        Session session=sessionFactory.getCurrentSession();
        completedOrder.setIdEmployee(session.get(Employee.class,idEmployee));
        completedOrder.setIdClientRequest(session.get(ClientRequest.class,idClientRequest));
        completedOrder.setIdMachine(session.get(Machine.class,idMachine));
        completedOrder.setIdTypeMachine(session.get(TypeMachine.class,idTypeMachine));
        completedOrder.setIdSerialNumber(session.get(SerialNumber.class,idSerialNumber));
        session.saveOrUpdate(completedOrder);
    }
}
