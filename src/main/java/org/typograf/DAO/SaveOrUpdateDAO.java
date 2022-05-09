package org.typograf.DAO;

import org.typograf.entity.ClientRequest;
import org.typograf.entity.TypeMachine;

public interface SaveOrUpdateDAO {
    void saveClientRequest(ClientRequest clientRequest);
    void updateClientRequest(ClientRequest clientRequest);
    void saveTypeMachine(TypeMachine typeMachine);
}
