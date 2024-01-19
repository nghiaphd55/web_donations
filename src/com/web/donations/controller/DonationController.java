package com.web.donations.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.donations.entity.Donation;
import com.web.donations.entity.User;
import com.web.donations.entity.UserDonation;
import com.web.donations.service.DonationService;
import com.web.donations.service.UserDonationService;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@Controller
@RequestMapping("/donation")
public class DonationController {

	@Autowired
	private DonationService donationService;

	@Autowired
	private UserDonationService userDonationService;

	@GetMapping("/listDonation")
	public String listDonation(Model theModel) {

		// Lấy đối tượng donation từ DAO.
		List<Donation> donations = donationService.getDonation();

		// Lấy tất cả dữ liệu trên DAO bỏ vào jsp
		theModel.addAttribute("donations", donations);

		return "admin/donation";
	}

	@PostMapping("/saveDonations")
	public String saveDonations(Donation donation) {

		/* Lưu donation vào service */
		donationService.saveDonations(donation);

		return "redirect:/donation/listDonation";
	}

	@GetMapping("/fillAll")
	public String fillAll(Model model, int offset) {
		int maxResult = 5;
		List<Donation> donations = donationService.findAll(offset, maxResult);

		model.addAttribute("donations", donations);

		return "admin/donation";
	}

	@GetMapping("/delete")
	public String deleteDonation(@RequestParam("donationId") int id) {

		donationService.deleteDonation(id);

		return "redirect:/donation/listDonation";
	}

	/* Hàm dùng tìm kiểm */
	@PostMapping("/search")
	public String getDonationBySearch(@RequestParam("searchValue") String value, Model model) {

		// Lấy data từ DAO lên
		model.addAttribute("donations", donationService.getDonationBySearch(value));

		return "admin/donation";
	}

	/* Hàm dùng để lấy dữ liệu bỏ form update */
	@GetMapping("/showFormEdit")
	public String showFormEdit(@RequestParam("donationId") int id, Model model) {

		// Hiển thị form sửa với dữ liệu cũ
		Donation donations = donationService.getDonationById(id);

		// Chuyển dữ liệu từ controller qua jsp
		model.addAttribute("donations", donations);

		return "admin/UpdateForm";
	}

	/* Hàm này dùng để cập nhập */
	@PostMapping("/update")
	public String update(Donation donation) {

		donationService.saveUpdate(donation);

		return "redirect:/donation/listDonation";
	}

	@GetMapping("/detail")
	public String detail(@RequestParam("donationId") int id, Model model) {

		// hiển thị form với dữ liệu cũ
		Donation donations = donationService.getDonationById(id);

		List<UserDonation> userDonations = userDonationService.getUserDonation(id);
			
		// Tạo 1 new ArrayList mới, để chứa kết quả lọc được
		List<UserDonation> resultList = new ArrayList();
		
		//bước 2: Ở dòng 111, for loop qua userDonations
		for (UserDonation ud : userDonations) {
			// bước 3: trong vòng lặp for, kiểm tra nếu phần tử nào có ud.getDonation().getDonationId() == với id ở trên thì
			resultList.add(ud);
		}
		
		// chuyển dữ liệu vào jsp
		model.addAttribute("donations", donations);
		model.addAttribute("userDonations", userDonations);

		return "admin/detail";
	}

	@GetMapping("/listUserDonation")
	public String userDonationList(@RequestParam("donationId") int donationId,Model model) {

	   // Lấy dữ liệu trong user donation ra bằng id 
	   List<UserDonation> userDonations = userDonationService.getUserDonation(donationId);
	  
	   // truyền nó vào vào jsp
	   model.addAttribute("userDonations", userDonations);
		
	   // trả về trang chi tiết
		return "admin/detail";
	}

}
