package org.typograf.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.typograf.classImp.SaveOrUpdateImpl;
import org.typograf.entity.ClientRequest;

@Service
@Transactional
public class SaveOrUpdateServiceImpl implements SaveOrUpdateService{
    @Autowired
    private SaveOrUpdateImpl saveOrUpdate;

    @Override
    public void saveClientRequest(ClientRequest clientRequest) {
        saveOrUpdate.saveClientRequest(clientRequest);

    }

    @Override
    public void updateClientRequest(ClientRequest clientRequest) {
        saveOrUpdate.updateClientRequest(clientRequest);

    }
}
