package forum.risingcreations.auth;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import forum.risingcreations.models.User;
import forum.risingcreations.services.UserService;

@Service
public class AuthUserDetailService implements UserDetailsService{
	
	@Autowired
	UserService userService;
	
	Map<String, Role> roleMap;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username == null || username.isEmpty())
			throw new UsernameNotFoundException(username);
		User user = userService.findByUsername(username);
		return new UserPrincipal(user);
	}

}
