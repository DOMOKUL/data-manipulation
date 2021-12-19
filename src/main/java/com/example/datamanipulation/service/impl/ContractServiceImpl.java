package com.example.datamanipulation.service.impl;

import com.example.datamanipulation.domain.Contract;
import com.example.datamanipulation.repository.ContractRepository;
import com.example.datamanipulation.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;

    @Override
    public Contract saveContract(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public Contract getContractById(UUID id) {
        boolean isClientPresent = contractRepository.findById(id).isPresent();
        if(isClientPresent){
            return contractRepository.findById(id).get();
        }
        throw new RuntimeException();
    }

    @Override
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public void deleteContractById(UUID id) {
        boolean isClientPresent = contractRepository.findById(id).isPresent();
        if (isClientPresent){
            contractRepository.deleteById(getContractById(id).getId());
        } else {
            throw new RuntimeException();
        }

    }

    @Override
    public List<Contract> saveAllContracts(List<Contract> contracts) {
        List<Contract> result = new ArrayList<>();
        contracts.forEach(contract -> result.add(saveContract(contract)));
        return result;
    }
}
