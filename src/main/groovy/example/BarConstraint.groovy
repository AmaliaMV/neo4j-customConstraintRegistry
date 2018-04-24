package example

import org.springframework.context.MessageSource
import org.springframework.validation.Errors

import grails.gorm.validation.ConstrainedProperty

import org.grails.datastore.gorm.validation.constraints.AbstractConstraint

class BarConstraint extends AbstractConstraint {

    BarConstraint(
        Class<?> constraintOwningClass,
        String constraintPropertyName,
        Object constraintParameter,
        MessageSource messageSource) {
        super(constraintOwningClass, constraintPropertyName, constraintParameter, messageSource)
    }

    @Override
    protected Object validateParameter(Object constraintParameter) {
        println "BarConstraint -> validateParameter: called"

        if (!constraintParameter instanceof String) {
            throw new IllegalArgumentException("Not supported")
        }

        return constraintParameter
    }

    @Override
    protected void processValidate(Object target, Object propertyValue, Errors errors) {
        if (constraintParameter && propertyValue =~ /[A-Z]/)
            rejectValue target, errors, "default.invalid.${name}.message", "${name}.invalid",
                        [constraintPropertyName, constraintOwningClass, propertyValue] as Object[]
    }

    @Override
    boolean supports(Class type) {
        return true
    }

    @Override
    String getName() {
        return 'BarConstraint'
    }
}
