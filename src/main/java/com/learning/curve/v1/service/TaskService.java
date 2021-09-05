package com.learning.curve.v1.service;

import com.learning.curve.v1.domain.dto.TaskDTO;
import com.learning.curve.v1.domain.entity.TaskEntity;
import com.learning.curve.v1.repository.TaskRepository;
import com.learning.curve.v1.value.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService() {}

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional(readOnly = true)
    public Page<TaskEntity> getAllTask(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }

    public Optional<TaskEntity> createTask(TaskDTO taskDTO) {

        // convert DTO to Entity
        TaskEntity creatingTask = new TaskEntity();
        creatingTask.setDescription(taskDTO.getDescription());
        creatingTask.setName(taskDTO.getName());

        // save
        TaskEntity savedTask = taskRepository.save(creatingTask);
        return Optional.of(savedTask);
    }
}
