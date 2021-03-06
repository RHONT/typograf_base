package org.typograf.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.typograf.classImp.SaveOrUpdateImpl;
import org.typograf.entity.ClientRequest;
import org.typograf.entity.CompletedOrder;
import org.typograf.entity.TypeMachine;
import org.typograf.entity.Work;

import java.time.LocalDate;

@Service
@Transactional
public class SaveOrUpdateServiceImpl implements SaveOrUpdateService{
    @Autowired
    private SaveOrUpdateImpl saveOrUpdate;

    @Override
    public void saveClientRequest(ClientRequest clientRequest) {
        saveOrUpdate.saveClientRequest(clientRequest);
    }

    @Override
    public void updateClientRequest(ClientRequest clientRequest) {
        saveOrUpdate.updateClientRequest(clientRequest);
    }

    @Override
    public void saveTypeMachine(TypeMachine typeMachine) {
        saveOrUpdate.saveTypeMachine(typeMachine);
    }

    @Override
    public void saveWork(Work work, Integer id_employee, Integer id_clientRequest, LocalDate dateWork, Integer timeForecast) {

        saveOrUpdate.saveWork(work,id_employee,id_clientRequest, dateWork,timeForecast);
    }

    @Override
    public void saveOrUpdateCompletedOrder(CompletedOrder completedOrder) {
        saveOrUpdate.saveOrUpdateCompletedOrder(completedOrder);
    }

    @Override
    public void saveOrUpdateCompletedOrder(CompletedOrder completedOrder,
                                           Integer idClientRequest,
                                           Integer idEmployee,
                                           Integer idMachine,
                                           Integer idTypeMachine,
                                           String idSerialNumber) {

        saveOrUpdate.saveOrUpdateCompletedOrder(completedOrder,
                                                idClientRequest,
                                                idEmployee,
                                                idMachine,
                                                idTypeMachine,
                                                idSerialNumber);

    }
}
