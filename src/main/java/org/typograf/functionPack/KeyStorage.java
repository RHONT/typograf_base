package org.typograf.functionPack;

public class KeyStorage {

    private Integer id_employee;
    private Integer id_ClientRequest;
    private Integer id_TypeMachine;
    private Integer id_machine;
    private String id_SerialNumber;

    private boolean lock=false;

    public KeyStorage() {
    }

//    public KeyStorage(Integer id_employee,
//                      Integer id_ClientRequest,
//                      Integer id_TypeMachine,
//                      Integer id_machine,
//                      String id_SerialNumber) {
//        this.id_employee = id_employee;
//        this.id_ClientRequest = id_ClientRequest;
//        this.id_TypeMachine = id_TypeMachine;
//        this.id_machine = id_machine;
//        this.id_SerialNumber = id_SerialNumber;
//        lock=true;
//    }

    public Integer getId_employee() {
        return id_employee;
    }

    public void setId_employee(Integer id_employee) {
        this.id_employee = id_employee;
    }

    public Integer getId_ClientRequest() {
        return id_ClientRequest;
    }

    public void setId_ClientRequest(Integer id_ClientRequest) {
        this.id_ClientRequest = id_ClientRequest;
    }

    public Integer getId_TypeMachine() {
        return id_TypeMachine;
    }

    public void setId_TypeMachine(Integer id_TypeMachine) {
        this.id_TypeMachine = id_TypeMachine;
    }

    public Integer getId_machine() {
        return id_machine;
    }

    public void setId_machine(Integer id_machine) {
        this.id_machine = id_machine;
    }

    public String getId_SerialNumber() {
        return id_SerialNumber;
    }

    public void setId_SerialNumber(String id_SerialNumber) {
        this.id_SerialNumber = id_SerialNumber;
    }

    public boolean isLock() {
        return lock;
    }
    public void setLock(boolean lock) {
        this.lock = lock;
    }

    @Override
    public String toString() {
        return "KeyStorage{" +
                "id_employee=" + id_employee +
                ", id_ClientRequest=" + id_ClientRequest +
                ", id_TypeMachine=" + id_TypeMachine +
                ", id_machine=" + id_machine +
                ", id_SerialNumber='" + id_SerialNumber + '\'' +
                ", lock=" + lock +
                '}';
    }
}
