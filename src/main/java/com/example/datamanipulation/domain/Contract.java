package com.example.datamanipulation.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class Contract {

    @Id
    @GeneratedValue
    private UUID id;
    private Integer serialNumber;
    private Integer typeId;
}
