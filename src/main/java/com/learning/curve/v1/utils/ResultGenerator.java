package com.learning.curve.v1.utils;

import com.learning.curve.v1.value.CommonValues;
import com.learning.curve.v1.value.Result;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ResultGenerator {

    public Result generateResultWithList(Iterable<?> list, String failMsg) {

        Result result = new Result();

        if (list == null || !list.iterator().hasNext()) {
            result.setCode(CommonValues.Code.FAIL);
            result.setMsg(failMsg);
        }
        else {
          result.setData(list);
          result.setCode(CommonValues.Code.SUCCESS);
        }
        return result;
    }

    public Result generateResultWithOptional(Optional<?> optional, String failMsg) {

        Result result = new Result();

        if (optional == null || !optional.isPresent()) {
            result.setCode(CommonValues.Code.FAIL);
            result.setMsg(failMsg);
        }
        else {
            result.setData(optional.get());
            result.setCode(CommonValues.Code.SUCCESS);
        }
        return result;
    }

    public Result generateResultWithPrimitive(Object primitive, String failMsg) {

        Result result = new Result();

        if (primitive == null) {
            result.setCode(CommonValues.Code.FAIL);
            result.setMsg(failMsg);
        }
        else {
            result.setData(primitive);
            result.setCode(CommonValues.Code.SUCCESS);
        }
        return result;
    }
}
