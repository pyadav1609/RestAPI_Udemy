package com.myProj.rest.webservice.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> userList=new ArrayList<>();
	static {
		userList.add(new User(101, "jack", new Date()));
		userList.add(new User(102, "adam", new Date()));
		userList.add(new User(103, "Eve", new Date()));
	}

	private int UserCount=103;
	
	/*public List<User>findAll(){
		return userList;
	}*/
	
	public Integer save(User user) {
		if(user.getId()==null && !userList.contains(user)) {
			user.setId(++UserCount);
		userList.add(user);}
		return user.getId();
	}
	
	public User findOne(Integer id) {
		for(User user: userList) {
			if(user.getId()==id) {
				return user;
			}
			
		}
		return null;
	}
			
			
	public User deleteById(Integer id) {
		for(User user: userList) {
			if(user.getId()==id) {
				userList.remove(user);
				return user;
			}
			
		}
		return null;
	}			
			
}
