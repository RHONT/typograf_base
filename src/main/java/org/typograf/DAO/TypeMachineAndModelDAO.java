package org.typograf.DAO;

import org.typograf.entity.Machine;
import org.typograf.entity.SerialNumber;
import org.typograf.entity.TypeMachine;

import java.util.List;

public interface TypeMachineAndModelDAO {

    List<TypeMachine> getAllTypeMachines();
    TypeMachine getSingleTypeMachine(Integer idTypeMachine);

    List<String> getAllModelName();
    Machine getSingleMachine(Integer idMachine);

    SerialNumber getSingleSerialNumber(String str);
}
