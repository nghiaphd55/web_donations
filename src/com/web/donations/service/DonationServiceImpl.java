package com.web.donations.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.web.donations.DAO.DonationDAO;
import com.web.donations.entity.Donation;

@Service
public class DonationServiceImpl implements DonationService {

	@Autowired
	private DonationDAO donationDAO;
	
	@Override
	@Transactional
	public List<Donation> getDonation() {
		return donationDAO.getDonation();
	}
	
	@Override
	@Transactional
	public void saveDonations(Donation donation) {
		donationDAO.saveDonations(donation);
	}
	
	@Override
	@Transactional
	public List<Donation> findAll(int offset, int maxResult) {
		return donationDAO.findAll(offset, maxResult);
	}
	
	@Override
	@Transactional
	public void deleteDonation(int id) {
		donationDAO.deleteDonation(id);
	}
	
	@Override
	@Transactional
	public List<Donation> getDonationBySearch(String value) {
		return donationDAO.getDonationBySearch(value);
	}
	
	@Override
	@Transactional
	public Donation getDonationById(int id) {
		return donationDAO.getDonationById(id);
	}
	
	@Override
	@Transactional
	public void saveUpdate(Donation donation) {
		donationDAO.saveUpdate(donation);
	}
}
