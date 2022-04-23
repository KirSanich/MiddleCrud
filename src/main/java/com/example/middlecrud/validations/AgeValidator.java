package com.example.middlecrud.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<AgeValidationConstraint, Integer> {


    @Override
    public void initialize(AgeValidationConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer inputAge, ConstraintValidatorContext constraintValidatorContext) {
       return inputAge !=null && inputAge.toString().matches("[0-9]+")
               && ((inputAge.toString().length()>0) && (inputAge.toString().length()<3));
    }
}
