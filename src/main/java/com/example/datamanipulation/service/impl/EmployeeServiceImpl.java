package com.example.datamanipulation.service.impl;

import com.example.datamanipulation.domain.Employee;
import com.example.datamanipulation.domain.Roles;
import com.example.datamanipulation.exception.UniqueConstraintException;
import com.example.datamanipulation.repository.EmployeeRepository;
import com.example.datamanipulation.repository.RoleRepository;
import com.example.datamanipulation.service.EmployeeService;
import com.example.datamanipulation.service.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    RoleRepository roleRepository;

    private final PasswordService passwordService;

    @Override
    public Employee loadEmployeeByLogin(String login) {
        Employee employee = employeeRepository.findByLogin(login);

//        if (employee == null){
//            throw new UsernameNotFoundException("Employee not found");
//        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployeeWithManagerRole(Roles roles) {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getRoles().equals(roles))
                .collect(Collectors.toList());
    }

    @Override
    public Employee saveEmployee(Employee employee) throws Exception {
        Employee employeeFromDB = employeeRepository.findByLogin(employee.getLogin());
        if (employeeFromDB!=null){
            throw new UniqueConstraintException("Employee with this login: "+employee.getLogin()+" is exist");
        }

        employee.setPassword(passwordService.encode(employee.getPassword()));
        employee.setTasks(List.of());
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee getEmployeeById(UUID id) {
        boolean isClientPresent = employeeRepository.findById(id).isPresent();
        if (isClientPresent) {
            return employeeRepository.findById(id).get();
        }
        throw new RuntimeException();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployeeById(UUID id) {
        boolean isClientPresent = employeeRepository.findById(id).isPresent();
        if (isClientPresent) {
            employeeRepository.deleteById(getEmployeeById(id).getId());
        } else {
            throw new RuntimeException();
        }

    }

    @Override
    public List<Employee> saveAllEmployees(List<Employee> employees) {
        List<Employee> result = new ArrayList<>();
        employees.forEach(employee -> {
            try {
                result.add(saveEmployee(employee));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return result;
    }

    @Override
    public Employee getByPasswordAndLogin(String login, String password){
        Employee employeeByPasswordAndLogin = employeeRepository.findEmployeeByPasswordAndLogin(password, login);
        if(employeeByPasswordAndLogin ==null){
            throw new RuntimeException();
        }
        return employeeByPasswordAndLogin;
    }



}
