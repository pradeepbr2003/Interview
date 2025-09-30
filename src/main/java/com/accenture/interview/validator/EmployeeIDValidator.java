package com.accenture.interview.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeeIDValidator implements ConstraintValidator<ValidateEmpId, Long> {

    @Override
    public void initialize(ValidateEmpId constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long empId, ConstraintValidatorContext constraintValidatorContext) {
        return !(empId == null || empId == 0);
    }
}
