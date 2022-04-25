package org.typograf.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "serial_number")
public class SerialNumber {
    @Id
    @Column(name = "id_serial_number", nullable = false, length = 30)
    private String id;


    private Machine idMachine;


    private List<CompletedOrder> completedOrders;


    private List<ClientRequest> clientRequests;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Machine getIdMachine() {
        return idMachine;
    }

    public void setIdMachine(Machine idMachine) {
        this.idMachine = idMachine;
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