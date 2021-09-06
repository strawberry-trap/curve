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
@RequestMapping("/api/v1/task")
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

    @GetMapping("/taskList")
    public Result getAlltask(Pageable pageable) {
        return taskService.getAllTasks(pageable);
    }

    @GetMapping("/task/{id}")
    public Result getOneTask(@PathVariable Long id) {
        return taskService.getOneTask(id);
    }

    @PostMapping("/createTask")
    public Result createTask(TaskDTO taskDTO) {
        return taskService.createTask(taskDTO);
    }

    @DeleteMapping("/deleteTask")
    public Result deleteTask(Long id) {
        return taskService.deleteTask(id);
    }
}
