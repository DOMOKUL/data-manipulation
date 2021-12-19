package com.example.datamanipulation.service.impl;

import com.example.datamanipulation.domain.Role;
import com.example.datamanipulation.repository.RoleRepository;
import com.example.datamanipulation.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getRoleById(Long id) {
        boolean isClientPresent = roleRepository.findById(id).isPresent();
        if (isClientPresent) {
            return roleRepository.findById(id).get();
        }
        throw new RuntimeException();
    }

    @Override
    public List<String> getAllRoles() {
        return List.of("ADMIN","USER","MANAGER");

    }

    @Override
    public void deleteRoleById(Long id) {
        boolean isClientPresent = roleRepository.findById(id).isPresent();
        if (isClientPresent) {
            roleRepository.deleteById(getRoleById(id).getId());
        } else {
            throw new RuntimeException();
        }

    }

    @Override
    public List<Role> saveAllRoles(List<Role> roles) {
        List<Role> result = new ArrayList<>();
        roles.forEach(role -> result.add(saveRole(role)));
        return result;
    }
}
