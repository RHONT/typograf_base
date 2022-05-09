package org.typograf.DAO;

import org.typograf.entity.ClientRequest;

public interface SaveOrUpdateDAO {
    void saveClientRequest(ClientRequest clientRequest);
    void updateClientRequest(ClientRequest clientRequest);
}
