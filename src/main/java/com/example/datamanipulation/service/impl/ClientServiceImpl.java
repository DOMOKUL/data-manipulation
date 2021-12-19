package com.example.datamanipulation.service.impl;

import com.example.datamanipulation.domain.Client;
import com.example.datamanipulation.repository.ClientRepository;
import com.example.datamanipulation.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClientById(UUID id) {
        boolean isClientPresent = clientRepository.findById(id).isPresent();
        if(isClientPresent){
            return clientRepository.findById(id).get();
        }
        throw new RuntimeException();
    }

    @Override
    public List<Client> getAllClients() {

        return clientRepository.findAll();
    }

    @Override
    public void deleteClientById(UUID id) {
        boolean isClientPresent = clientRepository.findById(id).isPresent();
        if (isClientPresent){
            clientRepository.deleteById(getClientById(id).getId());
        } else {
            throw new RuntimeException();
        }

    }

    @Override
    public List<Client> saveAllClients(List<Client> clients) {
        List<Client> result = new ArrayList<>();
        clients.forEach(client -> result.add(saveClient(client)));
        return result;
    }

//    @Override
//    public Client getClientByName(String companyName){
//        boolean isClientPresent = clientRepository.findBy(companyName,getClientByName(companyName));
//    }
}
