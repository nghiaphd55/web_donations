package com.web.donations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.donations.DAO.RoleDao;
import com.web.donations.DAO.UserDAO;
import com.web.donations.entity.Role;
import com.web.donations.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	// cần nhúng userDao
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RoleDao roleDao;
	
	@Override
	@Transactional
	public List<User> getUser() {
		return userDAO.getUser();
	}
	
	@Override
	@Transactional
	public void saveUser(User theUser) {
		userDAO.saveUser(theUser);
	}
	
	
	@Override
	@Transactional
	public List<User> getUsersByPage(int offset,int limit) {
		return userDAO.getUsersByPage(offset, limit);
	}
	
	@Override
	@Transactional
	public void deleteUser(int theId) {
		userDAO.deleteUser(theId);
	}
	
	@Override
	@Transactional
	public void updateUser(User theUser) {
		userDAO.updateUser(theUser);
	}
	
	@Override
	@Transactional
	public User getUserById(int theId) {
		return userDAO.getUserById(theId);
	}
	
	@Override
	@Transactional
	public List<User> getUserBySearch(String searchValue) {
		return userDAO.getUserBySearch(searchValue);
	}
	
	  @Override
	  @Transactional 
	  public void getLockUp(int idUser) { 
		  userDAO.getLockUp(idUser);
	  }
	  
	  @Override
	  @Transactional
	  public void getOpen(int idUser) {
		  userDAO.getOpen(idUser);
	  }
	 
}
