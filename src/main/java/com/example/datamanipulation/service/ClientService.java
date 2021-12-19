package com.example.datamanipulation.service;

import com.example.datamanipulation.domain.Client;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    Client saveClient(Client client);

    Client getClientById(UUID id);

    List<Client> getAllClients();

    void deleteClientById(UUID id);

    List<Client> saveAllClients(List<Client> clients);


}
