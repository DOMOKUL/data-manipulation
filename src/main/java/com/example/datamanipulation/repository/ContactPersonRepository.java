package com.example.datamanipulation.repository;

import com.example.datamanipulation.domain.ClientContacts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactPersonRepository extends JpaRepository<ClientContacts, UUID> {
}
