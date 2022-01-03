package com.example.datamanipulation.service;

import com.example.datamanipulation.domain.TaskType;

import java.util.List;

public interface TaskTypeService {

    TaskType saveTaskType(TaskType role);

    TaskType getTaskTypeById(Long id);

    List<TaskType> getAllTaskTypes();

    void deleteTaskTypeById(Long id);

    List<TaskType> saveAllTaskTypes(List<TaskType> taskTypes);
}
