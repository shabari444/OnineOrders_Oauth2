/*package com.rest.service.OnlineOrders.Controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static Logger LOG = LoggerFactory.getLogger(UserDetailsService.class);
	
	@Autowired
	private UserController userService;

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		
		Collection<? extends GrantedAuthority> rolesList = new ArrayList<String>();
		rolesList.add("Admin");
		rolesList.add("user");
		List<MyUser> allUsers = null;
		MyUser checkuser = new MyUser();
		List<Object> userRoleList = new ArrayList<>();
		try {
			UserDetails object = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			LOG.info("UserDeatials:"+object.toString());
			if(object instanceof UserDetails) {
				checkuser.setUserID(((UserDetails) object).getUsername());
				checkuser.setPassword(((UserDetails) object).getPassword());
			}
			allUsers = userService.getAllMyUsers();
			
		} catch (Exception e) {
			LOG.error("Exception occured while creating user:"+e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!allUsers.contains(checkuser)) {
			throw new UsernameNotFoundException("User name or password are incorrect");
		}
	 
		 return new User(checkuser.getUserID(),checkuser.getPassword(),new ArrayList<>());
		
	}
	

}
*/