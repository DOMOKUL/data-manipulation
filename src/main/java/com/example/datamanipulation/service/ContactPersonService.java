package com.example.datamanipulation.service;

import com.example.datamanipulation.domain.ClientContacts;

import java.util.List;
import java.util.UUID;

public interface ContactPersonService {

    ClientContacts saveContactPerson(ClientContacts clientContacts);

    ClientContacts getContactPersonById(UUID id);

    List<ClientContacts> getAllContactPersons();

    void deleteContactPersonById(UUID id);

    List<ClientContacts> saveAllContactPersons(List<ClientContacts> clientContacts);
}
