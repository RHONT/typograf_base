package org.typograf.DAO;

import org.typograf.entity.ClientRequest;
import org.typograf.entity.TypeMachine;

import java.util.List;

public interface ClientOrderDAO {
    public List<TypeMachine> spisokTypeMachines();
    public List<String> spisokModel();
    public void saveOrder(ClientRequest clientRequest);
}
