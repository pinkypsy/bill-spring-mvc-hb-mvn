package constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface CourseCode {
    String defaultCode = "LUV";

    //default course code with 1 value
//    public String value() default defaultCode;

    //default course code with multiple values
    public String[] value() default {defaultCode};


    //default error message
    public String message() default "must start with " + defaultCode;

    //default group (can group related constraints
    public Class<?>[] groups() default {};

    //default payload (provide custom detail about validation failure)
    public Class<? extends Payload>[]  payload() default {};
}
