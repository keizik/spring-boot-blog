package lt.keizik.ieva.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class AdminService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) {
		if (username.equals(Admin.NAME)) {
			return new Admin();
		}
		return null;
	}

}