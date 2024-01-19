package com.web.donations.DAO;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.donations.entity.User;

public interface UserDAO extends Serializable  {
	
	public List<User> getUser();
	
	public void  saveUser(User theUser);

	public List<User> getUsersByPage(int offset, int limit);

	public void deleteUser(int theId);
	
	public User getUserById(int theId);
	
	public void updateUser(User theUser);
	
	public List<User> getUserBySearch(String searchValue);
	
	public void getLockUp(int idUser);
	
	public void getOpen(int idUser);

} 
