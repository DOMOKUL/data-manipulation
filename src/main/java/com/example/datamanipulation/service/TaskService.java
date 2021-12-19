package com.example.datamanipulation.service;

import com.example.datamanipulation.domain.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    Task saveTask(Task role);

    Task getTaskById(UUID id);

    List<Task> getAllTasks();

    void deleteTaskById(UUID id);

    List<Task> saveAllTasks(List<Task> taskPriorities);
}
