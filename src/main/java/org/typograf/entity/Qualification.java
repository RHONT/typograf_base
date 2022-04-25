package org.typograf.entity;

import javax.persistence.*;

@Entity
@Table(name = "qualification")
public class Qualification {



    private Employee idEmployee;


    private TypeMachine idTypeMachine;

    @Column(name = "qualification")
    private Integer qualification;


    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public Employee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Employee idEmployee) {
        this.idEmployee = idEmployee;
    }

    public TypeMachine getIdTypeMachine() {
        return idTypeMachine;
    }

    public void setIdTypeMachine(TypeMachine idTypeMachine) {
        this.idTypeMachine = idTypeMachine;
    }

    public Integer getQualification() {
        return qualification;
    }

    public void setQualification(Integer qualification) {
        this.qualification = qualification;
    }

}