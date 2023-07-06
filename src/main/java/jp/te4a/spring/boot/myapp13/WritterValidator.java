package jp.te4a.spring.boot.myapp13;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
public class WritterValidator implements ConstraintValidator<WritterValid, String>{
	String ok;
	@Override
	public void initialize(WritterValid nv) {ok = nv.ok();}
	@Override
	public boolean isValid(String in, ConstraintValidatorContext cxt) {
		if(in == null) {
			return false;
		}
		System.out.println(in.equals(ok));
		return in.equals(ok);
	}
}
