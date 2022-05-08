package org.typograf.DAO;

import org.typograf.entity.ClientRequest;
import org.typograf.entity.Machine;
import org.typograf.entity.SerialNumber;
import org.typograf.entity.TypeMachine;

import java.util.List;

public interface ClientOrderDAO {
    public List<TypeMachine> spisokTypeMachines();
    public List<String> spisokModel();
    public void saveOrder(ClientRequest clientRequest);
    public void updateOrder(ClientRequest clientRequest);
    public TypeMachine getTypeMachine(Integer idTypeMachine);
    public Machine getMachine(Integer idMachine);
    public SerialNumber getSerialNumber(String str);
    public List<ClientRequest> getAllClientRequest();
    public ClientRequest getOneClientRequest(Integer idClientRequest);
}
