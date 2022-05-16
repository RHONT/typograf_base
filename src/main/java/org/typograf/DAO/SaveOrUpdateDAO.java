package org.typograf.DAO;

import org.typograf.entity.ClientRequest;
import org.typograf.entity.TypeMachine;
import org.typograf.entity.Work;

public interface SaveOrUpdateDAO {
    void saveClientRequest(ClientRequest clientRequest);
    void updateClientRequest(ClientRequest clientRequest);
    void saveTypeMachine(TypeMachine typeMachine);

    void saveWork(Work work);
}
