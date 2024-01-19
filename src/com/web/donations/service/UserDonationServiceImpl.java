package com.web.donations.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.web.donations.DAO.UserDonationDao;
import com.web.donations.entity.UserDonation;

@Service
public class UserDonationServiceImpl implements UserDonationService {
	@Autowired
	private UserDonationDao userDonationDao;

	@Override
	@Transactional
	public List<UserDonation> getUserDonation(int donationId) {
		return userDonationDao.getUserDonation(donationId);
	}
	
	@Override
	@Transactional
	public void saveUserDonation(UserDonation userDonation) {
		userDonationDao.saveUserDonation(userDonation);
	}
	
}
