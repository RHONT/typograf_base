package org.typograf.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class OrderDTO {
    private Integer idTypeMachine;
    private Integer idMachine;
    private String idSerialNumber;
    @Size(min = 3, message = " Минимум 2 символа")
    @NotBlank(message = " Введите название организации")
    private String firm;
    @NotBlank(message = " Введите ИНН")
    private String innFirm;
    @NotBlank(message = " Введите имя")
    private String nameClient;
    @NotBlank(message = " Введите номер телефона")
    private String phoneClient;
    @NotBlank(message = "Проблема должна быть описана")
    private String descProblem;
    private LocalDate dataWish;
    @NotBlank(message = " Введите адрес")
    private String adress;


    public OrderDTO() {
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

}
