package com.example.datamanipulation.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Client {

    @Id
    @GeneratedValue
    private UUID id;
    private String companyName;
    private boolean status;
    @OneToOne
    @JoinColumn(name = "contact_person_id")
    private ClientContacts clientContacts;
    @OneToMany(mappedBy = "client")
    private List<Task> tasks;

}
