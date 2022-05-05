package org.typograf.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "client_request")
public class ClientRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client_request", nullable = false)
    private Integer id;

    @Column(name = "firm", length = 30)
    private String firm;

    @Column(name = "inn_firm", length = 30)
    private String innFirm;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type_machine")
    private TypeMachine idTypeMachine;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_machine")
    private Machine idMachine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_serial_number")
    private SerialNumber idSerialNumber;

    @Column(name = "name_client", length = 30)
    private String nameClient;

    @Column(name = "phone_client", length = 30)
    private String phoneClient;

    @Lob
    @Column(name = "desc_problem")
    private String descProblem;

    @Column(name = "difficilty")
    private Integer difficilty;

    @Column(name = "adress", length = 100)
    private String adress;

    @Column(name = "data_wish")
    private LocalDate dataWish;

    @Column(name = "time_forecast")
    private Integer timeForecast;

    public Integer getTimeForecast() {
        return timeForecast;
    }

    public ClientRequest() {
    }

    public ClientRequest(String firm, String innFirm, TypeMachine idTypeMachine, Machine idMachine,
                         SerialNumber idSerialNumber, String nameClient, String phoneClient,
                         String descProblem, LocalDate dataWish) {
        this.firm = firm;
        this.innFirm = innFirm;
        this.idTypeMachine = idTypeMachine;
        this.idMachine = idMachine;
        this.idSerialNumber = idSerialNumber;
        this.nameClient = nameClient;
        this.phoneClient = phoneClient;
        this.descProblem = descProblem;
        this.dataWish=dataWish;
    }

    public void setTimeForecast(Integer timeForecast) {
        this.timeForecast = timeForecast;
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



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public TypeMachine getIdTypeMachine() {
        return idTypeMachine;
    }

    public void setIdTypeMachine(TypeMachine idTypeMachine) {
        this.idTypeMachine = idTypeMachine;
    }

    public Machine getIdMachine() {
        return idMachine;
    }

    public void setIdMachine(Machine idMachine) {
        this.idMachine = idMachine;
    }

    public SerialNumber getIdSerialNumber() {
        return idSerialNumber;
    }

    public void setIdSerialNumber(SerialNumber idSerialNumber) {
        this.idSerialNumber = idSerialNumber;
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

    public Integer getDifficilty() {
        return difficilty;
    }

    public void setDifficilty(Integer difficilty) {
        this.difficilty = difficilty;
    }

    @Override
    public String toString() {
        return "ClientRequest{" +
                "id=" + id +
                ", firm='" + firm + '\'' +
                ", innFirm='" + innFirm + '\'' +
                ", idTypeMachine=" + idTypeMachine +
                ", idMachine=" + idMachine +
                ", idSerialNumber=" + idSerialNumber +
                ", nameClient='" + nameClient + '\'' +
                ", phoneClient='" + phoneClient + '\'' +
                ", descProblem='" + descProblem + '\'' +
                ", difficilty=" + difficilty +
                '}';
    }
}