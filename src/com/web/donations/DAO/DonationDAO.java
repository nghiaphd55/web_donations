package com.web.donations.DAO;

import java.util.List;

import org.springframework.ui.Model;

import com.web.donations.entity.Donation;

public interface DonationDAO {
	
	public List<Donation> getDonation();
	
	public void saveDonations(Donation donation);
	
    public List<Donation> findAll(int offset, int maxResult);

    public void deleteDonation(int id);
    
    public List<Donation> getDonationBySearch(String value);
    
    public Donation getDonationById(int id);
    
    public void saveUpdate(Donation donation);

}
