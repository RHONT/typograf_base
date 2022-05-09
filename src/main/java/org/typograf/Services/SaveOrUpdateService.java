package org.typograf.Services;

import org.typograf.entity.ClientRequest;

public interface SaveOrUpdateService {
    void saveClientRequest(ClientRequest clientRequest);
    void updateClientRequest(ClientRequest clientRequest);
}
