package com.learning.curve.v1.controller;

import com.learning.curve.v1.domain.dto.TaskDTO;
import com.learning.curve.v1.domain.entity.TaskEntity;
import com.learning.curve.v1.service.TaskService;
import com.learning.curve.v1.utils.ResultGenerator;
import com.learning.curve.v1.value.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TaskController {

    private TaskService taskService;
    private ResultGenerator resultGenerator;

    public TaskController() {
    }

    @Autowired
    public TaskController(TaskService taskService, ResultGenerator resultGenerator) {
        this.taskService = taskService;
        this.resultGenerator = resultGenerator;
    }

    @GetMapping("/api/v1/taskList")
    public Result getAlltask(@RequestParam Pageable pageable) {

        Page<TaskEntity> allTask = taskService.getAllTask(pageable);
        return resultGenerator.generateResultWithList(allTask, "태스크 목록을 가져올 수 없습니다.");
    }

    @PostMapping("/api/v1/createTask")
    public Result createTask(@RequestParam TaskDTO taskDTO) {
        Optional<TaskEntity> createdTask = taskService.createTask(taskDTO);
        return resultGenerator.generateResultWithOptional(createdTask, "태스크를 생성할 수 없습니다.");
    }
}
