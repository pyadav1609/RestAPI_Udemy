package com.myProj.rest.webservice.restfulwebservices.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

//import javax.persistence.GeneratedValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userService;

	// reteriveUsers
	@GetMapping("/users")
	public List<User> reteriveAllUsers() {
		/*List<User> users=*/return userService.findAll();
		/*Iterator<User> iterator=users.iterator();
		while(iterator.hasNext()) {
			Resource<User> resource= new Resource<User>();
			Integer id=iterator.next().getId();
			ControllerLinkBuilder link=linkTo(methodOn(this.getClass()).retriveUser(id));
			resource.add(link.withRel("user"));
			return resource;
			}
		return null;*/
	}

	
	@GetMapping("/users/{id}")
	public Resource<User> retriveUser(@PathVariable int id) {
		System.out.println("--------in retriveUser----------");
		User user = userService.findOne(id);
		if (user == null) 
			throw new UserNotFoundError("there is no such user with id: " + id);
	
			Resource<User> resource= new Resource<User>(user);
			
			ControllerLinkBuilder link=linkTo(methodOn(this.getClass()).reteriveAllUsers());
			resource.add(link.withRel("all-users"));
	
		return resource;
	}

	
	@PostMapping("/users")
	public void createUser(@Validated @RequestBody User user) {
		userService.save(user);
	}

	
	@DeleteMapping("/users/{id}")
	public User deleteUser(@PathVariable int id) {
		User user = userService.deleteById(id);
		if (user == null) {
			throw new UserNotFoundError(" no such user to delete with id: " + id);
		}
		return null;
	}

}
