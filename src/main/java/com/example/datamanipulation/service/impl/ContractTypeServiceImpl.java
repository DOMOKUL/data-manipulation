package com.example.datamanipulation.service.impl;

import com.example.datamanipulation.domain.ContractType;
import com.example.datamanipulation.repository.ContractTypeRepository;
import com.example.datamanipulation.service.ContractTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractTypeServiceImpl implements ContractTypeService {

    private final ContractTypeRepository contractTypeRepository;

    @Override
    public ContractType saveContractType(ContractType contract) {
        return contractTypeRepository.save(contract);
    }

    @Override
    public ContractType getContractTypeById(Long id) {
        boolean isClientPresent = contractTypeRepository.findById(id).isPresent();
        if (isClientPresent) {
            return contractTypeRepository.findById(id).get();
        }
        throw new RuntimeException();
    }

    @Override
    public List<ContractType> getAllContractTypes() {
        return contractTypeRepository.findAll();
    }

    @Override
    public void deleteContractTypeById(Long id) {
        boolean isClientPresent = contractTypeRepository.findById(id).isPresent();
        if (isClientPresent) {
            contractTypeRepository.deleteById(getContractTypeById(id).getId());
        } else {
            throw new RuntimeException();
        }

    }

    @Override
    public List<ContractType> saveAllContractTypes(List<ContractType> contractTypes) {
        List<ContractType> result = new ArrayList<>();
        contractTypes.forEach(contractType -> result.add(saveContractType(contractType)));
        return result;
    }
}
