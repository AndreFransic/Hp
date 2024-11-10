package com.example.hphelper.validation;

import com.example.hphelper.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StateValidation implements ConstraintValidator<State, String> {

    @Override
    public boolean isValid(String Value, ConstraintValidatorContext context) {
        if (Value == null){
            return false;
        }
        if (Value.equals("已发布")  || Value.equals("草稿")){
            return true;
        }
        return false;
    }
}
