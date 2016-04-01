package spring.rest.model;

import java.util.ArrayList;
import java.util.List;


public class Users {
	
	List<User> user = new ArrayList<User>();

	public List<User> getUsers() {
		return user;
	}

	public void setUsers(List<User> user) {
		this.user = user;
	}
	
}
