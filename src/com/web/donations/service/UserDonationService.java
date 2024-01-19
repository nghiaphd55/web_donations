package com.web.donations.service;

import java.util.List;

import org.springframework.ui.Model;

import com.web.donations.entity.UserDonation;

public interface UserDonationService {

	public List<UserDonation> getUserDonation(int donationId);
	
	public void saveUserDonation(UserDonation userDonation);
	
}
