package com.example.datamanipulation.service;

import com.example.datamanipulation.domain.Contract;
import com.example.datamanipulation.domain.ContractType;

import java.util.List;
import java.util.UUID;

public interface ContractTypeService {

    ContractType saveContractType(ContractType contract);

    ContractType getContractTypeById(Long id);

    List<ContractType> getAllContractTypes();

    void deleteContractTypeById(Long id);

    List<ContractType> saveAllContractTypes(List<ContractType> contractTypes);
}
