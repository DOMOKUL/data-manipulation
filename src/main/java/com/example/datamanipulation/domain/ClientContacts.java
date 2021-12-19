package com.example.datamanipulation.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class ClientContacts {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String fax;
    private String postalAddress;
    @OneToOne(mappedBy = "clientContacts")
    private Client client;
}
