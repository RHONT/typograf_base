package org.typograf.DAO;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MapsForClientDAO {
    public Map<Integer,String> GetListTypeMachines();
    public Map<Integer,String> GetListMachines();
    public List<String> GetSerialNumber();
}
