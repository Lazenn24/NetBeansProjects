/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practicauno.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

/**
 *
 * @author thepinguin
 */
@Pattern.List({@Pattern(regexp = "^[^@]+@[^@]+\\.[a-zA-Z]{2,}$")})
@Constraint(validatedBy = {})
@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface email {

    String message() default "{com.mycompany.practicauno.validator.email}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
