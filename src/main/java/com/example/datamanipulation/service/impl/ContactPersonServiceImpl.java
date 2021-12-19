package com.example.datamanipulation.service.impl;

import com.example.datamanipulation.domain.ClientContacts;
import com.example.datamanipulation.repository.ContactPersonRepository;
import com.example.datamanipulation.service.ContactPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContactPersonServiceImpl implements ContactPersonService {

    private final ContactPersonRepository contactPersonRepository;

    @Override
    public ClientContacts saveContactPerson(ClientContacts clientContacts) {
        return contactPersonRepository.save(clientContacts);
    }

    @Override
    public ClientContacts getContactPersonById(UUID id) {
        boolean isClientPresent = contactPersonRepository.findById(id).isPresent();
        if(isClientPresent){
            return contactPersonRepository.findById(id).get();
        }
        throw new RuntimeException();
    }

    @Override
    public List<ClientContacts> getAllContactPersons() {
        return contactPersonRepository.findAll();
    }

    @Override
    public void deleteContactPersonById(UUID id) {
        boolean isClientPresent = contactPersonRepository.findById(id).isPresent();
        if (isClientPresent){
            contactPersonRepository.deleteById(getContactPersonById(id).getId());
        } else {
            throw new RuntimeException();
        }

    }

    @Override
    public List<ClientContacts> saveAllContactPersons(List<ClientContacts> clientContacts) {
        List<ClientContacts> result = new ArrayList<>();
        clientContacts.forEach(contactPerson -> result.add(saveContactPerson(contactPerson)));
        return result;
    }
}
