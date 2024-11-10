package com.example.hphelper.anno;

import com.example.hphelper.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

//自创注解，用于检测文章状态State

@Documented
@Constraint(
        validatedBy = {StateValidation.class}//指定提供注解规则的类
)
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)


public @interface State {
    String message() default "{参数只能是已发布或草稿}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
