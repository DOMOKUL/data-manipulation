package com.example.datamanipulation.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Role{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;



}
