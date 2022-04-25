package org.typograf.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "machine")
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_machine", nullable = false)
    private Integer id;


    private TypeMachine idTypeMachine;

    @Column(name = "model_machine", length = 30)
    private String modelMachine;


    private List<SerialNumber> serialNumbers;


    private List<CompletedOrder> completedOrders;

    private List<ClientRequest> clientRequests;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TypeMachine getIdTypeMachine() {
        return idTypeMachine;
    }

    public void setIdTypeMachine(TypeMachine idTypeMachine) {
        this.idTypeMachine = idTypeMachine;
    }

    public String getModelMachine() {
        return modelMachine;
    }

    public void setModelMachine(String modelMachine) {
        this.modelMachine = modelMachine;
    }

    public List<SerialNumber> getSerialNumbers() {
        return serialNumbers;
    }

    public void setSerialNumbers(List<SerialNumber> serialNumbers) {
        this.serialNumbers = serialNumbers;
    }

    public List<CompletedOrder> getCompletedOrders() {
        return completedOrders;
    }

    public void setCompletedOrders(List<CompletedOrder> completedOrders) {
        this.completedOrders = completedOrders;
    }

    public List<ClientRequest> getClientRequests() {
        return clientRequests;
    }

    public void setClientRequests(List<ClientRequest> clientRequests) {
        this.clientRequests = clientRequests;
    }

}