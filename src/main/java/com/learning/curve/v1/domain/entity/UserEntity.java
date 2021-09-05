package com.learning.curve.v1.domain.entity;

import com.learning.curve.v1.value.CommonValues;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name="USER_NAME")
    private String name;

    @Enumerated(EnumType.STRING)
    private CommonValues.Role role;

    @OneToMany(mappedBy = "id") // in 1:N relationship, owner of relation is always N
    private List<TaskEntity> tasks = new ArrayList<>();

    // getter & setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommonValues.Role getRole() {
        return role;
    }

    public void setRole(CommonValues.Role role) {
        this.role = role;
    }

    public List<TaskEntity> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskEntity> tasks) {
        this.tasks = tasks;
    }
}
