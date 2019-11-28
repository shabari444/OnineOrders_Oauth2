package com.rest.service.OnlineOrders.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rest.service.OnlineOrders.VO.MyUser;;

@Service
public class MyUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserController userService;

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		
		/*Collection<? extends GrantedAuthority> rolesList = new ArrayList<String>();
		rolesList.add("Admin");
		rolesList.add("user");*/
		List<MyUser> allUsers = null;
		MyUser checkuser = new MyUser();
		try {
			UserDetails object = (UserDetails) SecurityContextHolder.getContext();
			if(object instanceof UserDetails) {
				checkuser.setuserID(((UserDetails) object).getUsername());
				checkuser.setPassword(((UserDetails) object).getPassword());
			}
			allUsers = userService.getAllMyUsers();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!allUsers.contains(checkuser)) {
			throw new UsernameNotFoundException("User name or password are incorrect");
		}
		 return new User(checkuser.getuserID(),checkuser.getPassword(),new ArrayList<>());
		
	}
	

}
