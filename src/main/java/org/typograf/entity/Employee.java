package org.typograf.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee", nullable = false)
    private Integer id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "surname", length = 20)
    private String surname;

    @Column(name = "email", length = 20)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @OneToMany(
            mappedBy = "idEmployee",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Qualification> qualificationList;

    @OneToMany(
            mappedBy = "idEmployee",
            cascade = CascadeType.ALL)
    private List<Work> workReports = new ArrayList<>();

    public void addWork(Work work){
        workReports.add(work);
        work.setIdEmployee(this);
    }

    public Employee() {
    }

    public Employee(Integer id, String name, String surname, String email, String phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Qualification> getQualificationList() {
        return qualificationList;
    }

    public void setQualificationList(List<Qualification> qualificationList) {
        this.qualificationList = qualificationList;
    }

    public List<Work> getWorkReports() {
        return workReports;
    }

    public void setWorkReports(List<Work> workReprorts) {
        this.workReports = workReprorts;
    }

}