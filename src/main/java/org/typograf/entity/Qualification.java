package org.typograf.entity;

import javax.persistence.*;

@Entity
@Table(name = "qualification")
public class Qualification {
    @EmbeddedId
    private QualificationId id;

    @MapsId("idEmployee")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_employee", nullable = false)
    private Employee idEmployee;

    @MapsId("idTypeMachine")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_type_machine", nullable = false)
    private TypeMachine idTypeMachine;

    @Column(name = "qualification")
    private Integer qualification;

    public QualificationId getId() {
        return id;
    }

    public void setId(QualificationId id) {
        this.id = id;
    }

    public Employee getIdEmployee() {
        return idEmployee;
    }

    public Qualification() {
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