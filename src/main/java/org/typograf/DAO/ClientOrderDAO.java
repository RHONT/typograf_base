package org.typograf.DAO;

import org.typograf.entity.ClientRequest;
import org.typograf.entity.Machine;
import org.typograf.entity.SerialNumber;
import org.typograf.entity.TypeMachine;

import java.util.List;

public interface ClientOrderDAO {

    List<ClientRequest> getAllClientRequest();
    ClientRequest getSingleClientRequest(Integer idClientRequest);
}
