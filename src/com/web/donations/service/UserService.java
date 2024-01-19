package com.web.donations.service;

import java.util.List;

import com.web.donations.entity.Role;
import com.web.donations.entity.User;

public interface UserService {
	
	public List<User> getUser();
	
	public void saveUser(User theUser);
	   
    public List<User> getUsersByPage(int offset,int limit);
    
    public void deleteUser(int theId);
    
    public User getUserById(int theId);
    
    public void updateUser(User theUser);
    
    public List<User> getUserBySearch(String searchValue);
    
	
	public void getLockUp(int idUser);
	
	public void getOpen(int idUser);
}
