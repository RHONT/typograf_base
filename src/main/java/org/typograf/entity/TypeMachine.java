package org.typograf.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "type_machine")
public class TypeMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_machine", nullable = false)
    private Integer id;

    @Column(name = "name_type", length = 15)
    private String nameType;

    @OneToMany(mappedBy = "idTypeMachine", cascade = CascadeType.ALL)
    List<Qualification> qls;

    @OneToMany(mappedBy = "typeMachine", cascade = CascadeType.ALL)
    List<Machine> typeMachineList;

    @OneToMany(mappedBy = "idTypeMachine", cascade = CascadeType.ALL)
    List<ClientRequest> ClientTypeMachineList;



    public TypeMachine() {


    }

    public List<ClientRequest> getClientTypeMachineList() {
        return ClientTypeMachineList;
    }

    public void setClientTypeMachineList(List<ClientRequest> clientTypeMachineList) {
        ClientTypeMachineList = clientTypeMachineList;
    }

    public List<Qualification> getQls() {
        return qls;
    }

    public void setQls(List<Qualification> qls) {
        this.qls = qls;
    }

    public List<Machine> getTypeMachineList() {
        return typeMachineList;
    }

    public void setTypeMachineList(List<Machine> typeMachineList) {
        this.typeMachineList = typeMachineList;
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