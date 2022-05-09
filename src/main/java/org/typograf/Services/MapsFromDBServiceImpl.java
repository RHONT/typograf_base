package org.typograf.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.typograf.DAO.MapsForClientDAO;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MapsFromDBServiceImpl implements MapsFromDBService{

    @Autowired
    private MapsForClientDAO mapsForClientDAO;

    @Override
    public Map<Integer, String> getListTypeMachines() {
        return mapsForClientDAO.getListTypeMachines();
    }

    @Override
    public Map<Integer, String> getListMachines() {
        return mapsForClientDAO.getListMachines();
    }

    @Override
    public List<String> getSerialNumber() {
        return mapsForClientDAO.getSerialNumber();
    }
}
