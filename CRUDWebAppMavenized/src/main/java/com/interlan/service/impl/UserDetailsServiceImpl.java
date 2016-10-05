package com.interlan.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.domain.GrantedAuthoritySid;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.interlan.dao.UserDao;
import com.interlan.model.Role;
import com.interlan.model.User;
import com.interlan.model.UserStatus;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = (User)userDao.findUserByName(userName);
		
		if(user != null){
			String username = user.getUsername();
			String password = user.getPassword();
			boolean enabled = user.getStatus().equals(UserStatus.ACTIVE);
			boolean accountNonExpired = user.getStatus().equals(UserStatus.ACTIVE);
			boolean credentialsNonExpired = user.getStatus().equals(UserStatus.ACTIVE);
			boolean accountNonLocked = user.getStatus().equals(UserStatus.ACTIVE);
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			
			for (Role role : user.getRoles()) {
				authorities.add(new SimpleGrantedAuthority(role.getRolename()));
			}
			
			org.springframework.security.core.userdetails.User springSecureUserObj = new org.springframework.security.core.userdetails.User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
			return springSecureUserObj;
		}
		else{
			throw new UsernameNotFoundException("User Not Found !...");
		}
	}

}
