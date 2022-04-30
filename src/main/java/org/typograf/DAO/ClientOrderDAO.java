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
    public TypeMachine getTypeMachine(Integer numb);
    public Machine getMachine(Integer numb);
    public SerialNumber getSerialNumber(String str);
}
