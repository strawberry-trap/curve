package com.learning.curve.v1.service;

import com.learning.curve.v1.domain.dto.UserDTO;
import com.learning.curve.v1.domain.entity.UserEntity;
import com.learning.curve.v1.repository.UserRepository;
import com.learning.curve.v1.utils.ResultGenerator;
import com.learning.curve.v1.value.CommonValues;
import com.learning.curve.v1.value.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith({MockitoExtension.class})
@MockitoSettings(strictness = Strictness.LENIENT)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ResultGenerator<UserDTO> resultGenerator;

    @Test
    @DisplayName("[UserService] getOneUser should return 1 record")
    void getOneUserTest() {

        // given
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setName("eric");
        user.setRole(CommonValues.Role.USER);
        given(userRepository.getOneUser(1L)).willReturn(Optional.of(user));

        // given
        UserDTO dto = new UserDTO(user.getId(), user.getName(), user.getRole());
        Result result = new Result();
        result.setCode(CommonValues.Code.SUCCESS);
        result.setData(dto);
        given(resultGenerator.generateResultWithPrimitive(dto, "유저 정보를 가져오는데 실패했습니다.")).willReturn(result);

        // when
        Result testingResult = userService.getOneUser(1L);

        // then
        Assertions.assertEquals(testingResult.getCode(), CommonValues.Code.SUCCESS);
    }

    @Test
    void getAllUsers() {
    }

    @Test
    void createUser() {
    }

    @Test
    void deleteUser() {
    }
}
