package org.typograf.DAO;

import org.typograf.entity.ClientRequest;
import org.typograf.entity.CompletedOrder;
import org.typograf.entity.TypeMachine;
import org.typograf.entity.Work;

import java.time.LocalDate;

public interface SaveOrUpdateDAO {
    void saveClientRequest(ClientRequest clientRequest);
    void updateClientRequest(ClientRequest clientRequest);
    void saveTypeMachine(TypeMachine typeMachine);
    void saveWork(Work work, Integer id_employee, Integer id_clientRequest, LocalDate dateWork, Integer timeForecast);

    void saveOrUpdateCompletedOrder(CompletedOrder completedOrder);


}
