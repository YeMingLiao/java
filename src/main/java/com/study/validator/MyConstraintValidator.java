package com.study.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by gf on 2018/10/16.
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object>{

    @Override
    public void initialize(MyConstraint myConstraint) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {

        System.out.println(value);
        return false;
    }
}
