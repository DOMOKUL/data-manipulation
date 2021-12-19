package com.example.datamanipulation.service;

import com.example.datamanipulation.domain.Task;
import com.example.datamanipulation.domain.TaskType;

import java.util.List;
import java.util.UUID;

public interface TaskTypeService {

    TaskType saveTaskType(TaskType role);

    TaskType getTaskTypeById(Long id);

    List<TaskType> getAllTaskTypes();

    void deleteTaskTypeById(Long id);

    List<TaskType> saveAllTaskTypes(List<TaskType> taskTypes);
}
