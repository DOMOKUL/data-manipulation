package com.example.datamanipulation.service.impl;

import com.example.datamanipulation.domain.Task;
import com.example.datamanipulation.domain.TaskType;
import com.example.datamanipulation.repository.TaskRepository;
import com.example.datamanipulation.repository.TaskTypeRepository;
import com.example.datamanipulation.service.TaskTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskTypeServiceImpl implements TaskTypeService {

    private final TaskTypeRepository taskTypeRepository;
    @Override
    public TaskType saveTaskType(TaskType role) {
        return taskTypeRepository.save(role);
    }

    @Override
    public TaskType getTaskTypeById(Long id) {
        boolean isClientPresent = taskTypeRepository.findById(id).isPresent();
        if (isClientPresent) {
            return taskTypeRepository.findById(id).get();
        }
        throw new RuntimeException();
    }

    @Override
    public List<TaskType> getAllTaskTypes() {
        return taskTypeRepository.findAll();
    }

    @Override
    public void deleteTaskTypeById(Long id) {
        boolean isClientPresent = taskTypeRepository.findById(id).isPresent();
        if (isClientPresent) {
            taskTypeRepository.deleteById(getTaskTypeById(id).getId());
        } else {
            throw new RuntimeException();
        }

    }

    @Override
    public List<TaskType> saveAllTaskTypes(List<TaskType> taskTypes) {
        List<TaskType> result = new ArrayList<>();
        taskTypes.forEach(taskType -> result.add(saveTaskType(taskType)));
        return result;
    }
}
