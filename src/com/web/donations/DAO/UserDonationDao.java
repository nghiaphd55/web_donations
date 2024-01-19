package com.web.donations.DAO;

import java.util.List;

import org.springframework.ui.Model;

import com.web.donations.entity.UserDonation;

public interface UserDonationDao {

	public List<UserDonation> getUserDonation(int donationId);
	
	public void saveUserDonation(UserDonation userDonation);
	
}
