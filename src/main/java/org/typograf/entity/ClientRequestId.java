package org.typograf.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class ClientRequestId {

    private Integer idTypeMachine;
    private Integer idMachine;
    private String idSerialNumber;
    @Size(min = 2, message = " Минимум 2 символа")
    private String firm;
    private String innFirm;
    private String nameClient;
    @NotBlank(message = " Введите номер телефона")
    private String phoneClient;
    private String descProblem;
    @NotNull(message = " Укажите желаемую дату")
    private LocalDate dataWish;
    private String adress;

    public ClientRequestId() {
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

    public LocalDate getDataWish() {
        return dataWish;
    }

    public void setDataWish(LocalDate dataWish) {
        this.dataWish = dataWish;
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
