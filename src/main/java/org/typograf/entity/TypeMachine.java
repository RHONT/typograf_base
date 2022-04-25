package org.typograf.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "type_machine")
public class TypeMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_machine", nullable = false)
    private Integer id;

    @Column(name = "name_type", length = 15)
    private String nameType;


    private List<CompletedOrder> completedOrders;


    private List<Qualification> qualifications;

    private List<ClientRequest> clientRequests;

    private List<Machine> machines;

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

    public List<CompletedOrder> getCompletedOrders() {
        return completedOrders;
    }

    public void setCompletedOrders(List<CompletedOrder> completedOrders) {
        this.completedOrders = completedOrders;
    }

    public List<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    public List<ClientRequest> getClientRequests() {
        return clientRequests;
    }

    public void setClientRequests(List<ClientRequest> clientRequests) {
        this.clientRequests = clientRequests;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

}