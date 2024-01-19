package com.web.donations.controller;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.donations.entity.Donation;
import com.web.donations.entity.UserDonation;
import com.web.donations.service.DonationService;
import com.web.donations.service.UserDonationService;

@Controller
@RequestMapping("/public")
public class PublicController {
	// Cần nhúng donation service
	@Autowired
	private DonationService donationService;

	// Cần nhúng user donation service
	@Autowired
	private UserDonationService userDonationService;

	@GetMapping("/home")
	public String home(Model model) {

		// Lấy danh sách hiển thị tất cả data của donation ở DAO lên
		List<Donation> donations = donationService.getDonation();

		// chuyển tất cả danh sách donation sang jsp
		model.addAttribute("donations", donations);

		return "public/home";
	}

	@GetMapping("/detail")
	public String detail(@RequestParam("donationId") int id, Model model) {

		// Hiển thị Form để hiển thị dữ liệu cũ 
		Donation donations = donationService.getDonationById(id);
		  
		// chuyển tất cả  các thuộc tính của donation qua jsp khớp với các trường trong form
		model.addAttribute("donations", donations);
		 
		return "public/detail";
	}

	@GetMapping("/showUserDonationForm")
	public String showUserDonationForm(Model model) {

		// Tạo user donation có các thuộc tính  ứng với các trường trong Form
		UserDonation userDonations = new UserDonation();

		// chuyển tất cả qua trang jsp
		model.addAttribute("userDonations", userDonations);

		return "public/userDonationForm";
	}

	@PostMapping("/saveUserDonation")
	public String saveUserDonation(UserDonation userDonation) {

//		userDonation.setUserId(17);
		
		userDonationService.saveUserDonation(userDonation);

		return "redirect:/public/home";
	}
}
