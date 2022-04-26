package org.typograf.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "machine")
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_machine", nullable = false)
    private Integer id;

    @Column(name = "model_machine", length = 30)
    private String modelMachine;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_machine")
    private TypeMachine typeMachine;


    @OneToMany(mappedBy = "machine", cascade = CascadeType.ALL)
    List<SerialNumber> serialNumberList;

    @OneToMany(mappedBy = "idMachine", cascade = CascadeType.ALL)
    List<ClientRequest> ClientMuchineList;

    public Machine() {
    }

    public TypeMachine getTypeMachine() {
        return typeMachine;
    }

    public void setTypeMachine(TypeMachine typeMachine) {
        this.typeMachine = typeMachine;
    }

    public List<SerialNumber> getSerialNumberList() {
        return serialNumberList;
    }

    public void setSerialNumberList(List<SerialNumber> serialNumberList) {
        this.serialNumberList = serialNumberList;
    }

    public List<ClientRequest> getClientMuchineList() {
        return ClientMuchineList;
    }

    public void setClientMuchineList(List<ClientRequest> clientMuchineList) {
        ClientMuchineList = clientMuchineList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TypeMachine getIdTypeMachine() {
        return typeMachine;
    }

    public void setIdTypeMachine(TypeMachine idTypeMachine) {
        this.typeMachine = idTypeMachine;
    }

    public String getModelMachine() {
        return modelMachine;
    }

    public void setModelMachine(String modelMachine) {
        this.modelMachine = modelMachine;
    }

}