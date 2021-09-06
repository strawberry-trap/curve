package com.learning.curve.v1.service;

import com.learning.curve.v1.domain.dto.TaskDTO;
import com.learning.curve.v1.domain.entity.TaskEntity;
import com.learning.curve.v1.repository.TaskRepository;
import com.learning.curve.v1.utils.ResultGenerator;
import com.learning.curve.v1.value.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TaskService {

    private TaskRepository taskRepository;
    private ResultGenerator resultGenerator;

    public TaskService() {}

    @Autowired
    public TaskService(TaskRepository taskRepository, ResultGenerator resultGenerator) {
        this.taskRepository = taskRepository;
        this.resultGenerator = resultGenerator;
    }

    /**
     * get task list
     * @param pageable
     * */
    @Transactional(readOnly = true)
    public Result getAllTasks(Pageable pageable) {

        Page<TaskEntity> allTask = taskRepository.findAll(pageable);
        return resultGenerator.generateResultWithList(allTask, "태스크 목록을 가져올 수 없습니다.");
    }

    @Transactional(readOnly = true)
    public Result getOneTask(Long id){
        TaskEntity task = taskRepository.getOneTaskById(id).get();
        TaskDTO dto = new TaskDTO();
        dto.setName(task.getName());
        dto.setDescription(task.getDescription());
        dto.setId(task.getId());

        return resultGenerator.generateResultWithPrimitive(dto, "id : " + id + " 의 태스크를 가져올 수 없습니다.");
    }

    /**
     * create task
     * @param taskDTO name, description
     * */
    public Result createTask(TaskDTO taskDTO) {

        // convert DTO to Entity
        TaskEntity creatingTask = new TaskEntity();
        creatingTask.setDescription(taskDTO.getDescription());
        creatingTask.setName(taskDTO.getName());

        // save
        TaskEntity savedTask = taskRepository.save(creatingTask);
        return resultGenerator.generateResultWithPrimitive(savedTask.getId(), "태스크를 생성할 수 없습니다.");
    }

    public Result deleteTask(Long id) {

        boolean result;

        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        }
        if (taskRepository.existsById(id)) result = false;
        else result = true;

        return resultGenerator.generateResultWithPrimitive(result, "태스크 삭제에 실패했습니다.");
    }
}
