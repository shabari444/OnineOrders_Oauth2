package com.rest.service.OnlineOrders.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rest.service.OnlineOrders.Repository.UserRepository;
import com.rest.service.OnlineOrders.VO.MyUser;

@RestController
public class UserController {
	
	@Autowired
	UserRepository MyUserRepository;

	@RequestMapping(value="/getAllMyUsers",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MyUser> getAllMyUsers() throws Exception{
		return MyUserRepository.findAll();
	}
	@RequestMapping(value="/getMyUserByID/{MyUserID}",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public Optional<MyUser> getMyUserByID(@PathVariable String MyUserID) throws Exception {
		return MyUserRepository.findById(MyUserID);
	}
	
	@RequestMapping(value="/createMyUser",method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public MyUser createMyUser(MyUser MyUser) throws Exception{
		MyUserRepository.save(MyUser);
		return MyUser;
	}
}
