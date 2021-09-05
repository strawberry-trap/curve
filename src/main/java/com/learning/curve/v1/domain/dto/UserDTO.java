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
}
