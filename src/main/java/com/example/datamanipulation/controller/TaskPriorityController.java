package com.example.datamanipulation.controller;

import com.example.datamanipulation.service.TaskPriorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/task-priorities")
@RequiredArgsConstructor
public class TaskPriorityController {

    private final TaskPriorityService taskPriorityService;

    @GetMapping
    public List<String> getTaskPriority(){
        return taskPriorityService.getAllTaskPriorities();
    }

}
