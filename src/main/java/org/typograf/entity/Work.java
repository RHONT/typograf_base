package org.typograf.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "work")
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_work", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_employee", nullable = false)
    private Employee idEmployee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client_request")
    private ClientRequest idClientRequest;

    @Column(name = "date_visit")
    private LocalDate dateVisit;

    @Column(name = "time_start")
    private LocalTime timeStart;

    @Column(name = "laid_down_time")
    private Integer laidDownTime;

    public Work() {
    }

    public Work(Integer id, LocalDate dateVisit, LocalTime timeStart, Integer laidDownTime) {
        this.id = id;
        this.dateVisit = dateVisit;
        this.timeStart = timeStart;
        this.laidDownTime = laidDownTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Employee idEmployee) {
        this.idEmployee = idEmployee;
    }

    public ClientRequest getIdClientRequest() {
        return idClientRequest;
    }

    public void setIdClientRequest(ClientRequest idClientRequest) {
        this.idClientRequest = idClientRequest;
    }

    public LocalDate getDateVisit() {
        return dateVisit;
    }

    public void setDateVisit(LocalDate dateVisit) {
        this.dateVisit = dateVisit;
    }

    public LocalTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalTime timeStart) {
        this.timeStart = timeStart;
    }

    public Integer getLaidDownTime() {
        return laidDownTime;
    }

    public void setLaidDownTime(Integer laidDownTime) {
        this.laidDownTime = laidDownTime;
    }

}