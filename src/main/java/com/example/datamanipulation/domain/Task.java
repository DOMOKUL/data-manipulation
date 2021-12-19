package com.example.datamanipulation.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    private String description;
    private Date createAt;
    private Date executionTime;
    private Date completedAt;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private TaskType type;
    private boolean isDone;
    @Enumerated(EnumType.STRING)
    private TaskPriorities priorities;
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Employee creator;
}
