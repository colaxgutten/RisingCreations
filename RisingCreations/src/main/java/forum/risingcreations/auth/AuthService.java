package forum.risingcreations.auth;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;

import forum.risingcreations.models.User;
import forum.risingcreations.services.UserService;

@Service
public class AuthService {
	
	@Autowired
	UserService userService;

	public void authenticateUser(String username, String password, HttpServletRequest request) {
		User user = userService.authenticatedUser(username, password);
		if (user!=null) {
		UserPrincipal userPrincipal = new UserPrincipal(user);
		authenticateUser(userPrincipal, request);
		}
	}
	
	public void authenticateUser(UserPrincipal userPrincipal, HttpServletRequest request) {
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userPrincipal, null, userPrincipal.getAuthorities());
		auth.setDetails(new WebAuthenticationDetails(request));
		SecurityContextHolder.getContext().setAuthentication(auth);
	}
}
