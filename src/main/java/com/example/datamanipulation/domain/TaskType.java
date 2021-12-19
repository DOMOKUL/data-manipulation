package com.example.datamanipulation.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class TaskType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "type")
    private List<Task> tasks;
}
