package com.learning.curve.v1.domain.dto;

import com.learning.curve.v1.value.CommonValues;

public class UserDTO {

    private Long id;
    private String name;
    private CommonValues.Role role;

    public UserDTO() { }

    public UserDTO(Long id, String name, CommonValues.Role role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

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
}
