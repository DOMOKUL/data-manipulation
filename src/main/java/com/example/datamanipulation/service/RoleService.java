package com.example.datamanipulation.service;

import com.example.datamanipulation.domain.Role;

import java.util.List;

public interface RoleService {

    Role saveRole(Role role);

    Role getRoleById(Long id);

    List<String> getAllRoles();

    void deleteRoleById(Long id);

    List<Role> saveAllRoles(List<Role> roles);
}
