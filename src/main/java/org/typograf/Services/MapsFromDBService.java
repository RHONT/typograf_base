package org.typograf.Services;

import java.util.List;
import java.util.Map;

public interface MapsFromDBService {
    Map<Integer,String> getListTypeMachines();
    Map<Integer,String> getListMachines();
    List<String> getSerialNumber();
}
