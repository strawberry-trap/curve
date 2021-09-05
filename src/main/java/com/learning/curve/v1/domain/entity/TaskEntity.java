package com.learning.curve.v1.domain.entity;

import javax.persistence.*;

@Entity
public class TaskEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TASK_ID")
    private Long id;

    @Column(name = "TASK_NAME")
    private String name;

    @Column(name = "TASK_DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "USER_ID") // FK
    private UserEntity user;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
