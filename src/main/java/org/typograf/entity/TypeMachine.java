package org.typograf.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "type_machine")
public class TypeMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_machine", nullable = false)
    private Integer id;

    @Column(name = "name_type", length = 15)
    private String nameType;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name="qualification",
            joinColumns = @JoinColumn(name="id_type_machine"),
            inverseJoinColumns = @JoinColumn(name="id_employee"))
    private List<Employee> employees;

    public void addEmployees(Employee employee) {
        if (employees==null) {
            employees=new ArrayList<>();
        }
        employees.add(employee);
        }



    public TypeMachine() {
    }

    public TypeMachine(Integer id, String nameType) {
        this.id = id;
        this.nameType = nameType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

}