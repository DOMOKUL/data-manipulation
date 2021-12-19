package com.example.datamanipulation.repository;

import com.example.datamanipulation.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
