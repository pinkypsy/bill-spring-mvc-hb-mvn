package constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//class for logic of the custom validation
public class CourseCodeConstraintValidator
implements ConstraintValidator<CourseCode,String> {
/*//    with 1 value of prefix
    private String coursePrefix;

        @Override
    public void initialize(CourseCode theCourseCode) {
coursePrefix = theCourseCode.value();
    }

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
//        theCode - data entered by user on HTML page
        boolean theResult;

        if (theCode != null) theResult = theCode.startsWith(coursePrefix);
        else theResult = true;

        return theResult;
    }*/

    //    with multiple values of prefixes
    private String [] coursePrefixes;



    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefixes = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
//        theCode - data entered by user on HTML page
        boolean theResult = false;
        if (theCode != null) {

            for (String prefix :
                    coursePrefixes) {
                theResult = theCode.startsWith(prefix);
                if (theResult) break;
            }

        }else theResult = true;
        System.out.println(constraintValidatorContext.getDefaultConstraintMessageTemplate());
        return theResult;
    }

}
