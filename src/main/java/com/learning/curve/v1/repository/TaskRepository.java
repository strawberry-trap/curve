package com.learning.curve.v1.repository;

import com.learning.curve.v1.domain.entity.TaskEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    @Query("select task from TaskEntity task")
    Page<TaskEntity> getAllTask(Pageable pageable);

    @Query("select task from TaskEntity task where task.id= :id")
    Optional<TaskEntity> getOneTaskById(Long id);

}
