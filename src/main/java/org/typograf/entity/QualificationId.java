package org.typograf.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class QualificationId implements Serializable {
    private static final long serialVersionUID = 2036383517894994636L;
    @Column(name = "id_employee", nullable = false)
    private Integer idEmployee;

    @Column(name = "id_type_machine", nullable = false)
    private Integer idTypeMachine;

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Integer getIdTypeMachine() {
        return idTypeMachine;
    }

    public void setIdTypeMachine(Integer idTypeMachine) {
        this.idTypeMachine = idTypeMachine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        QualificationId entity = (QualificationId) o;
        return Objects.equals(this.idEmployee, entity.idEmployee) &&
                Objects.equals(this.idTypeMachine, entity.idTypeMachine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmployee, idTypeMachine);
    }

}