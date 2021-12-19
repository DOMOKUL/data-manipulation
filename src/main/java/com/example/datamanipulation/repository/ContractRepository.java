package com.example.datamanipulation.repository;

import com.example.datamanipulation.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContractRepository extends JpaRepository<Contract, UUID> {
}
