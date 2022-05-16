package org.typograf.Services;

import org.typograf.entity.ClientRequest;
import org.typograf.entity.TypeMachine;
import org.typograf.entity.Work;

public interface SaveOrUpdateService {
    void saveClientRequest(ClientRequest clientRequest);
    void updateClientRequest(ClientRequest clientRequest);

    void saveTypeMachine(TypeMachine typeMachine);

    void saveWork(Work work);
}
