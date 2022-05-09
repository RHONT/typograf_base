package org.typograf.DAO;

import org.typograf.entity.ClientRequest;
import org.typograf.entity.Machine;
import org.typograf.entity.SerialNumber;
import org.typograf.entity.TypeMachine;

import java.util.List;

public interface ClientOrderDAO {
    public List<TypeMachine> spisokTypeMachines();
    public List<String> getAllModel();
    public void saveClientRequest(ClientRequest clientRequest);
    public void updateClientRequest(ClientRequest clientRequest);
    public TypeMachine getTypeMachine(Integer idTypeMachine);
    public Machine getMachine(Integer idMachine);
    public SerialNumber getSerialNumber(String str);
    public List<ClientRequest> getAllClientRequest();
    public ClientRequest getOneClientRequest(Integer idClientRequest);
}
