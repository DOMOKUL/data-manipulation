package com.example.datamanipulation.service.impl;

import com.example.datamanipulation.domain.Task;
import com.example.datamanipulation.repository.TaskRepository;
import com.example.datamanipulation.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    @Override
    public Task saveTask(Task role) {
        return taskRepository.save(role);
    }

    @Override
    public Task getTaskById(UUID id) {
        boolean isClientPresent = taskRepository.findById(id).isPresent();
        if (isClientPresent) {
            return taskRepository.findById(id).get();
        }
        throw new RuntimeException();
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteTaskById(UUID id) {
        boolean isClientPresent = taskRepository.findById(id).isPresent();
        if (isClientPresent) {
            taskRepository.deleteById(getTaskById(id).getId());
        } else {
            throw new RuntimeException();
        }

    }

    @Override
    public List<Task> saveAllTasks(List<Task> tasks) {
        List<Task> result = new ArrayList<>();
        tasks.forEach(task -> result.add(saveTask(task)));
        return result;
    }
}
