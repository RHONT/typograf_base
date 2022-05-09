package org.typograf.Services;

import java.util.List;
import java.util.Map;

public interface MapsFromDBService {
    public Map<Integer,String> getListTypeMachines();
    public Map<Integer,String> getListMachines();
    public List<String> getSerialNumber();
}
