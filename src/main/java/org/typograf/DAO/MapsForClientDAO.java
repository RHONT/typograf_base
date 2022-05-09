package org.typograf.DAO;

import java.util.List;
import java.util.Map;

public interface MapsForClientDAO {
    Map<Integer,String> getListTypeMachines();
    Map<Integer,String> getListMachines();
    List<String> getSerialNumber();
}
