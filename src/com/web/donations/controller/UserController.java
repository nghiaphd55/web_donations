package com.web.donations.controller;

import java.util.List;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.donations.DAO.RoleDao;
import com.web.donations.DAO.UserDAO;
import com.web.donations.entity.Role;
import com.web.donations.entity.User;
import com.web.donations.entity.UserDto;
import com.web.donations.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	// nhúng UserDao
	@Autowired
	private UserService userService;

	@Autowired
	private RoleDao roleDao;


	
	@GetMapping("/home")
	public String home() {
		return "admin/home";
	}

	@GetMapping("/listUser")
	public String listUser(Model theModel) {

		// Lấy đối tượng user từ DAO.
		List<User> theUsers = userService.getUser();

//		System.out.println(theUsers.get(0).getRole().getRoleName());

		// Thêm user vào model
		theModel.addAttribute("users", theUsers);

		// trả về view
		return "admin/account";
	}

	@PostMapping("/saveUser")
	public String saveUser(UserDto theUser) {

		User user = new User();
		user.setUserName(theUser.getUserName());
		user.setAddress(theUser.getAddress());
		user.setEmail(theUser.getEmail());
		user.setFullName(theUser.getFullName());
		user.setPassword(theUser.getPassword());
		user.setPhoneNumber(theUser.getPhoneNumber());
		user.setNote(theUser.getNote());
		user.setStatus(theUser.getStatus());

		/* giờ lấy hết role lên */
		List<Role> role = roleDao.getRole();

//		  lặp qua cái roles đó. tìm cái nào có roleName = với cái từ jsp gửi lên thì set vô
		for (Role roles : role) {
			if (String.valueOf(roles.getId()).equalsIgnoreCase(theUser.getRole())) {
				user.setRole(roles);
			}

		}

		// lưu user vào service
		userService.saveUser(user);

		return "redirect:/user/listUser";
	}

	@GetMapping("/getAll")
	public String findAll(Model model, Integer offset) {
		int limit = 5;
		List<User> users = userService.getUsersByPage(offset, limit);

		model.addAttribute("users", users);
		return "admin/account";
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int theId) {

		// xóa user
		userService.deleteUser(theId);

		return "admin/account";
	}
	  
	@GetMapping("/showUser") 
	  public String showEditForm(@RequestParam("userId") int userId, Model model) { 
			// Lấy thông tin từ cơ sở dữ liệu hoặc nơi lưu trữ khác //
		    // Hiển thị form sửa với dữ liệu cũ
	  
			  User user = userService.getUserById(userId); 

			  model.addAttribute("user", user);
			 
		 	  return "admin/account"; 
	  }

	@PostMapping("/edit")
	public String editUser(UserDto userDto) {	
		
		User user = new User();
		user.setId(userDto.getId());
		user.setUserName(userDto.getUserName());
		user.setAddress(userDto.getAddress());
		user.setEmail(userDto.getEmail());
		user.setFullName(userDto.getFullName());
		user.setPassword(userDto.getPassword());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setNote(userDto.getNote());
		user.setStatus(userDto.getStatus());

		/* giờ lấy hết role lên */
		List<Role> role = roleDao.getRole();
		
//		  lặp qua cái roles đó. tìm cái nào có roleName = với cái từ jsp gửi lên thì set vô
		for (Role roles : role) {
			if (String.valueOf(roles.getId()).equalsIgnoreCase(userDto.getRole())) {
				user.setRole(roles);
			}

		}		
		
		// lưu user vào service
		userService.updateUser(user);
		
		// Chuyển hướng hoặc hiển thị thông báo thành công
		return "admin/account";
	}

	  @PostMapping("/search") 
	  public String getUserBySearch(@RequestParam("searchValue") String searchValue, Model theModel) {
	  
		  // Lấy đối tượng user từ DAO. 
		  theModel.addAttribute("users", userService.getUserBySearch(searchValue));
		  
		  // trả về trang chủ 
		  return "admin/account"; 
	  }
	
	  @PostMapping("/lockUp") 
	  public String getLockUp(@RequestParam("idUser") int idUser) {
	  
		  userService.getLockUp(idUser);
		  
		  return "redirect:/user/listUser"; 
	  }	
	  
	  @PostMapping("/open")
	  public String getOpen(@RequestParam("idUser") int idUser) {
		  
		  userService.getOpen(idUser);
		  
		  return "redirect:/user/listUser"; 
	  }
}
