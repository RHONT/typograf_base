package org.typograf.entity;

import javax.persistence.*;

@Entity
@Table(name = "completed_orders")
public class CompletedOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_completed_orders", nullable = false)
    private Integer id;

    @Column(name = "id_client_request", nullable = false)
    private Integer idClientRequest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_employee")
    private Employee idEmployee;

    @Column(name = "firm", length = 30)
    private String firm;

    @Column(name = "inn_firm", length = 30)
    private String innFirm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_machine")
    private TypeMachine idTypeMachine;

    @ManyToOne(fetch = FetchType.LAZY)
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

    @Column(name = "fact_difficilty")
    private Integer factDifficilty;

    @Lob
    @Column(name = "expert_opinion")
    private String expertOpinion;

    @Lob
    @Column(name = "jadgment_company")
    private String jadgmentCompany;

    @Column(name = "rating_firm")
    private Integer ratingFirm;

    @Column(name = "engineer_assessment")
    private Integer engineerAssessment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdClientRequest() {
        return idClientRequest;
    }

    public void setIdClientRequest(Integer idClientRequest) {
        this.idClientRequest = idClientRequest;
    }

    public Employee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Employee idEmployee) {
        this.idEmployee = idEmployee;
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

    public Integer getFactDifficilty() {
        return factDifficilty;
    }

    public void setFactDifficilty(Integer factDifficilty) {
        this.factDifficilty = factDifficilty;
    }

    public String getExpertOpinion() {
        return expertOpinion;
    }

    public void setExpertOpinion(String expertOpinion) {
        this.expertOpinion = expertOpinion;
    }

    public String getJadgmentCompany() {
        return jadgmentCompany;
    }

    public void setJadgmentCompany(String jadgmentCompany) {
        this.jadgmentCompany = jadgmentCompany;
    }

    public Integer getRatingFirm() {
        return ratingFirm;
    }

    public void setRatingFirm(Integer ratingFirm) {
        this.ratingFirm = ratingFirm;
    }

    public Integer getEngineerAssessment() {
        return engineerAssessment;
    }

    public void setEngineerAssessment(Integer engineerAssessment) {
        this.engineerAssessment = engineerAssessment;
    }


}