package jp.te4a.spring.boot.myapp13.service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import jp.te4a.spring.boot.myapp13.bean.UserBean;
import jp.te4a.spring.boot.myapp13.form.UserForm;
import jp.te4a.spring.boot.myapp13.repository.UserRepository;
@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public UserForm create(UserForm userForm) {
		userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
		//userForm.setPassword(userForm.getPassword());
		UserBean userBean = new UserBean();
		BeanUtils.copyProperties(userForm, userBean);
		userRepository.save(userBean);
		return userForm;
	}
}
