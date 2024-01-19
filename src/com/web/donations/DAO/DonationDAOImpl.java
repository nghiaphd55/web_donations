package com.web.donations.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.web.donations.entity.Donation;

@Repository
public class DonationDAOImpl implements DonationDAO {

	/* cần nhúng session factory */
	@Autowired
	private SessionFactory sessionFactory;
	
	/* Hàm này dùng để Hiển thị danh sách donation */
	@Override
	@Transactional
	public List<Donation> getDonation() {
		
		/* Lay phien làm việc session */
		Session currentSession = sessionFactory.getCurrentSession();
		
		/*
		 * Tạo ra câu lệnh query
		 */		
		Query<Donation> theQuery = currentSession.createQuery("from Donation", Donation.class);
		
		/* Thực hiện câu lệnh truy vấn và trả về List */
		List<Donation> donations = theQuery.getResultList();
		
		/* Trả về kết quả */
		return donations;
	}
	
	public void saveDonations(Donation donation) {
		/* Bây giờ gọi session hibernate */
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(donation);
	}
	
	/* Phân trang */
	@Override
	@Transactional
    public List<Donation> findAll(int offset, int maxResult) {
		Session session = sessionFactory.openSession();
		maxResult = 5; // Đặt kích thước trang theo ý muốn của bạn
		int offsetValue = (offset - 1) * maxResult; // Tính giá trị offset
		
		// Thực hiện câu lênh truy vấn    	
    	Query query = session.createQuery("FROM Donation")
    	.setMaxResults(maxResult)
    	.setFirstResult(offsetValue);
    	
    	List<Donation> donationList = query.list();
    	session.close(); // Đóng session sau khi sử dụng.
    	
    	return donationList;
	}
	
	/* Hàm dùng để xóa */
	@Override
	@Transactional
	public void deleteDonation(int id) {
		
		// Bây giờ gọi session hibernate 
		Session currentSession = sessionFactory.getCurrentSession();
		
		// xóa id record của bảng Donation bằng khóa chính id
    	Query<Donation> theQuery = currentSession
    							   .createQuery("delete from Donation where id=:donationId");
    	
    	theQuery.setParameter("donationId", id);
    	
    	theQuery.executeUpdate();

	}

	/* Hàm dùng tìm kiếm */
	public List<Donation> getDonationBySearch(String value) {
		
		
		/* Bây giờ gọi session hibernate */
		Session currentSession = sessionFactory.getCurrentSession();
		
		/* Tạo câu lệnh Query */
		Query<Donation> theQuery = currentSession.
				createQuery("from Donation where phoneNumber like :value "
							 + "or code like :value", Donation.class);

		theQuery.setParameter("value", "%" + value + "%");
		
		/* Thực hiện câu lệnh truy vấn và trả về List */
		List<Donation> donations = theQuery.getResultList();
		
		return donations;
	}
	
	/* Hàm này dùng lấy dữ liệu truyền vào form jsp */
	@Override
	@Transactional
	public Donation getDonationById(int id) {
		// Bây giờ gọi session trong hibernate
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Bây giờ lấy từ database sử dung khóa chính
    	Donation theDonation = currentSession.get(Donation.class, id);
    	
    	return theDonation;
	}
	
	/* Hàm này dùng lưu dữ liệu sau edit form xong */
	@Override
	@Transactional
	public void saveUpdate(Donation donation) {
		Session currentSession = sessionFactory.getCurrentSession();//khởi tạo phiên trong hibernate
		 
		// cập nhập lại dữ liệu cho donation
		currentSession.update(donation);
	}
}
