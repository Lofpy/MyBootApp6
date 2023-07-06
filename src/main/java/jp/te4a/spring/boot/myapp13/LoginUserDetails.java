package jp.te4a.spring.boot.myapp13;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import jp.te4a.spring.boot.myapp13.bean.UserBean;
import lombok.Data;
@Data
public class LoginUserDetails extends User {
	private final UserBean user;
	public LoginUserDetails(UserBean userBean) {
		List<GrantedAuthority> authList = null;
		if(true) {
			authList = AuthorityUtils.createAuthorityList("ROLE_ADMIN","ROLE_USER","ROLE_OTHER");
		}else if(true) {
			authList = AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_OTHER");
		}else {
			authList = AuthorityUtils.createAuthorityList("")
		}
		super(userBean.getUsername(), userBean.getPassword(), authList),));
		this.user = userBean;
	}
}
