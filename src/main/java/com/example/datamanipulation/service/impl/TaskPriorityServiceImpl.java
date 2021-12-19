package com.example.datamanipulation.service.impl;

import com.example.datamanipulation.service.TaskPriorityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskPriorityServiceImpl implements TaskPriorityService {

    @Override
    public List<String> getAllTaskPriorities() {
        return List.of("HIGH", "MEDIUM", "LOW");
    }
}
