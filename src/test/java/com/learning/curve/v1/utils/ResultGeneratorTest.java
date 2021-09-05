package com.learning.curve.v1.utils;

import com.learning.curve.v1.value.CommonValues;
import com.learning.curve.v1.value.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = { ResultGenerator.class })
class ResultGeneratorTest {

    @Autowired
    ResultGenerator resultGenerator;

    @Test
    @DisplayName("[generateResultWithList] null or empty input should return fail code")
    void generateResultWithListTest() {

        Result nullResult = resultGenerator.generateResultWithList(null, "");
        Result emptyResult = resultGenerator.generateResultWithList(new ArrayList<>(), "");

        Assertions.assertAll(
                () -> Assertions.assertEquals(nullResult.getCode(), CommonValues.Code.FAIL),
                () -> Assertions.assertEquals(emptyResult.getCode(), CommonValues.Code.FAIL)
        );
    }

    @Test
    @DisplayName("[generateResultWithOptional] null or empty input should return fail code")
    void generateResultWithOptionalTest() {

        Result nullResult = resultGenerator.generateResultWithOptional(null, "");
        Result emptyResult = resultGenerator.generateResultWithOptional(Optional.empty(), "");

        Assertions.assertAll(
                () -> Assertions.assertEquals(nullResult.getCode(), CommonValues.Code.FAIL),
                () -> Assertions.assertEquals(emptyResult.getCode(), CommonValues.Code.FAIL)
        );
    }
}
