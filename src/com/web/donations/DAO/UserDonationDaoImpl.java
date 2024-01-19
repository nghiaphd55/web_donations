package com.web.donations.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.web.donations.entity.User;
import com.web.donations.entity.UserDonation;

@Repository
public class UserDonationDaoImpl implements UserDonationDao {
	// Cần nhúng đối tượng session Factory
	@Autowired
	private SessionFactory sessionFactory;

	// Hàm dùng hiển thị
	@Override
	@Transactional
	public List<UserDonation> getUserDonation(int donationId) {
		Session currentSession = sessionFactory.getCurrentSession();

		// Use a named parameter :donationId in the query
		Query<UserDonation> theQuery = currentSession.createQuery("from UserDonation where donationId = :donationId", UserDonation.class);

		// Set the parameter value
		theQuery.setParameter("donationId", donationId);

		// Execute the query and return the result list
		List<UserDonation> userDonations = theQuery.getResultList();

		return userDonations;
		}
	
	// Hàm dùng để thêm người 
	@Override
	@Transactional
	public void saveUserDonation(UserDonation userDonation) {
		
		// Bây gọi phiên session Hibernate 
		Session currentSession = sessionFactory.getCurrentSession();
		
		// lưu data vào user donation
		currentSession.save(userDonation);
	}
}
