package com.example.datamanipulation.service;

import com.example.datamanipulation.domain.Contract;

import java.util.List;
import java.util.UUID;

public interface ContractService {

    Contract saveContract(Contract contract);

    Contract getContractById(UUID id);

    List<Contract> getAllContracts();

    void deleteContractById(UUID id);

    List<Contract> saveAllContracts(List<Contract> contracts);
}
