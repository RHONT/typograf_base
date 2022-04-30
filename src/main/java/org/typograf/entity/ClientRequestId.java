package org.typograf.entity;

import javax.persistence.Column;
import javax.persistence.Lob;

public class ClientRequestId {
    private Integer idTypeMachine;
    private Integer idMachine;
    private String idSerialNumber;
    private String firm;
    private String innFirm;
    private String nameClient;
    private String phoneClient;
    private String descProblem;

    public ClientRequestId() {
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getInnFirm() {
        return innFirm;
    }

    public void setInnFirm(String innFirm) {
        this.innFirm = innFirm;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getPhoneClient() {
        return phoneClient;
    }

    public void setPhoneClient(String phoneClient) {
        this.phoneClient = phoneClient;
    }

    public String getDescProblem() {
        return descProblem;
    }

    public void setDescProblem(String descProblem) {
        this.descProblem = descProblem;
    }

    public Integer getIdTypeMachine() {
        return idTypeMachine;
    }

    public void setIdTypeMachine(Integer idTypeMachine) {
        this.idTypeMachine = idTypeMachine;
    }

    public Integer getIdMachine() {
        return idMachine;
    }

    public void setIdMachine(Integer idMachine) {
        this.idMachine = idMachine;
    }

    public String getIdSerialNumber() {
        return idSerialNumber;
    }

    public void setIdSerialNumber(String idSerialNumber) {
        this.idSerialNumber = idSerialNumber;
    }
}
