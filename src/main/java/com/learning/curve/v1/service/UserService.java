package com.learning.curve.v1.service;

import com.learning.curve.v1.domain.dto.UserDTO;
import com.learning.curve.v1.domain.entity.UserEntity;
import com.learning.curve.v1.repository.UserRepository;
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
public class UserService {

    private UserRepository userRepository;
    private ResultGenerator resultGenerator;

    public UserService() {}

    @Autowired
    public UserService(UserRepository userRepository, ResultGenerator resultGenerator) {
        this.userRepository = userRepository;
        this.resultGenerator = resultGenerator;
    }

    @Transactional(readOnly = true)
    public Result getOneUser(Long id) {
        UserEntity userEntity = userRepository.getOneUser(id).get();
        UserDTO userDTO = new UserDTO(userEntity.getId(), userEntity.getName(), userEntity.getRole());
        return resultGenerator.generateResultWithPrimitive(userDTO, "유저 정보를 가져오는데 실패했습니다.");
    }

    @Transactional(readOnly = true)
    public Result getAllUsers(Pageable pageable) {
        Page<UserEntity> users = userRepository.getAllUsers(pageable);
        return resultGenerator.generateResultWithList(users, "유저 리스트를 가져오는데 실패했습니다.");
    }

    public Result createUser(UserDTO userDTO) {

        // convert DTO to entity
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setName(userDTO.getName());
        userEntity.setRole(userDTO.getRole());

        // save
        UserEntity savedUser = userRepository.save(userEntity);

        return resultGenerator.generateResultWithPrimitive(savedUser.getId(), "유저 생성에 실패했습니다.");
    }

    public Result deleteUser(Long id) {

        boolean result;

        if (userRepository.existsById(id)) {
            userRepository.deleteUserById(id);
        }
        if (userRepository.existsById(id)) result = false;
        else result = true;

        return resultGenerator.generateResultWithPrimitive(result, "태스크 삭제에 실패했습니다.");
    }
}
