package vn.codegym.chuong.common;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
//@Constraint(validatedBy = AgeRangeNumberConstraintValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PositiveNumber {
    String message() default "The number must be positive";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
