package jp.te4a.spring.boot.myapp13;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = WritterValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WritterValid{
	String ok();
	String message() default "{ok}と入力してください.";
	
	Class<?>[]groups() default {};
	
	Class<? extends Payload>[] payload() default{};
}