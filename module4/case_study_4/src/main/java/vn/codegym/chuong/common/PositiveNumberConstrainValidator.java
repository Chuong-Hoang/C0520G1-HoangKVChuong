package vn.codegym.chuong.common;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PositiveNumberConstrainValidator implements ConstraintValidator<PositiveNumber, String> {
    boolean isNumber = true;
    // validate number

    @Override
    public void initialize(PositiveNumber constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(!isNumber){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Number is not valid").addConstraintViolation();
            return false;
        } else {
            // continue checks.
        }
        return true;
    }
}
