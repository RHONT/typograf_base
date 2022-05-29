package org.typograf.DTO;

import org.typograf.entity.ClientRequest;
import org.typograf.entity.Machine;
import org.typograf.entity.SerialNumber;
import org.typograf.entity.TypeMachine;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

// Client
public class ClientRequestDTO {
    private Integer id;
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
    @Min(value = 1, message = "Минимум 1 час")
    @Max(value = 10, message = "Максимум 10")
    private Integer timeForecast;
//     в будущем завалидировать дату
    private LocalDate dataWish;
    @NotBlank(message = " Введите адрес")
    private String adress;
    @Min(value = 1, message = "Мин. сложность 1")
    @Max(value = 10, message = "Макс. сложность 10")
    private Integer difficilty;

    public ClientRequestDTO() {
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

    public Integer getTimeForecast() {
        return timeForecast;
    }

    public void setTimeForecast(Integer timeForecast) {
        this.timeForecast = timeForecast;
    }

    public Integer getDifficilty() {
        return difficilty;
    }

    public void setDifficilty(Integer difficilty) {
        this.difficilty = difficilty;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void fillDTO(ClientRequest clientRequest){
        this.id=clientRequest.getId();
        this.idTypeMachine=clientRequest.getIdTypeMachine().getId();
        this.idMachine=clientRequest.getIdMachine().getId();
        this.idSerialNumber=clientRequest.getIdSerialNumber().getId();
        this.firm = clientRequest.getFirm();
        this.innFirm=clientRequest.getInnFirm();
        this.nameClient=clientRequest.getNameClient();
        this.phoneClient=clientRequest.getPhoneClient();
        this.descProblem=clientRequest.getDescProblem();
        this.timeForecast=clientRequest.getTimeForecast();
        this.dataWish=clientRequest.getDataWish();
        this.adress=clientRequest.getAdress();
        this.difficilty=clientRequest.getDifficilty();
    }

    public void fillData(ClientRequest clientRequest, TypeMachine typeMachine, Machine machine, SerialNumber serialNumber){
        clientRequest.setAdress(this.adress);
        clientRequest.setDataWish(this.dataWish);
        clientRequest.setDescProblem(this.descProblem);
        clientRequest.setFirm(this.firm);
        clientRequest.setIdMachine(machine);
        clientRequest.setIdTypeMachine(typeMachine);
        clientRequest.setIdSerialNumber(serialNumber);
        clientRequest.setInnFirm(this.innFirm);
        clientRequest.setNameClient(this.nameClient);
        clientRequest.setPhoneClient(this.phoneClient);
        clientRequest.setTimeForecast(this.timeForecast);
        clientRequest.setDifficilty(this.difficilty);
    }

}
