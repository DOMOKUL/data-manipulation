package com.example.datamanipulation.repository;

import com.example.datamanipulation.domain.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskTypeRepository extends JpaRepository<TaskType, Long> {
}
