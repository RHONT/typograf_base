package org.typograf.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "serial_number")
public class SerialNumber {
    @Id
    @Column(name = "id_serial_number", nullable = false, length = 30)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_machine", nullable = false)
    private Machine machine;

    @OneToMany(mappedBy = "idSerialNumber")
    private List<ClientRequest> ClientSerialNumber;

    public List<ClientRequest> getClientSerialNumber() {
        return ClientSerialNumber;
    }

    public SerialNumber() {
    }

    public void setClientSerialNumber(List<ClientRequest> clientSerialNumber) {
        ClientSerialNumber = clientSerialNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine idMachine) {
        this.machine = idMachine;
    }

}