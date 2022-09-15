package org.typograf.DAO;

import org.typograf.entity.ClientRequest;

import java.util.List;

public interface ClientOrderDAO {

    List<ClientRequest> getAllClientRequest();
    ClientRequest getSingleClientRequest(Integer idClientRequest);
}
