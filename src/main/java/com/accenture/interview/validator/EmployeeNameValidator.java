package com.accenture.interview.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeeNameValidator implements ConstraintValidator<ValidateEmpName, String> {

    @Override
    public void initialize(ValidateEmpName constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String empName, ConstraintValidatorContext constraintValidatorContext) {
        return empName.matches("[Aa-zZ]+");
    }
}
