package com.example.datamanipulation.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue
    private UUID id;
    private String phone;
    private String email;
    private String login;
    private String password;
    @Enumerated(EnumType.STRING)
    private Roles roles;
    @OneToMany(mappedBy = "creator")
    private List<Task> tasks;
}
