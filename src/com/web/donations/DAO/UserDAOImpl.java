package com.web.donations.DAO;

import java.util.List;

import javax.swing.tree.RowMapper;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StaleObjectStateException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.web.donations.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	/* cần nhúng session factory */
	@Autowired
	private SessionFactory sessionFactory;	
	
	/* Hàm này dùng để Hiển thị danh sách user */
	@Override
	@Transactional
	public List<User> getUser() {
		
		/* Lay phien làm việc session */
		Session currentSession = sessionFactory.getCurrentSession();
		
		/*
		 * Tạo ra câu lệnh query
		 */		
		Query<User> theQuery = currentSession.createQuery("from User", User.class);
		
		/* Thực hiện câu lệnh truy vấn và trả về List */
		List<User> users = theQuery.getResultList();
		
		/* Trả về kết quả */
		return users;
	}
	
	
	/* Hàm này dùng lưu DB */
	@Override
	@Transactional
	public void saveUser(User theUser) {
		
		// Bây giờ gọi session hibernate
		Session currentSession = sessionFactory.getCurrentSession();
				
		// lưu user vào DB
		currentSession.save(theUser);
		
	}

    
	/* Hàm này dùng để phân trang */
    @Override
    @Transactional
    public List<User> getUsersByPage(int offset,int limit){        	
    	Session session = sessionFactory.openSession();
    	limit = 5; // Đặt kích thước trang theo ý muốn của bạn
    	int offsetValue = (offset - 1) * limit; // Tính giá trị offset

    	// Thực hiện câu lênh truy vấn    	
    	Query query = session.createQuery("FROM User")
    	.setMaxResults(limit)
    	.setFirstResult(offsetValue);

    	List<User> userList = query.list();
    	session.close(); // Đóng session sau khi sử dụng

    	return userList;
    }    

    @Override
    @Transactional
    public void deleteUser(int theId) {
    	
    	// Bây giờ gọi session hibernate
    	Session currentSession = sessionFactory.getCurrentSession();
    	
    	// Xóa user bằng khóa chính
    	Query<User> theQuery = currentSession.createQuery("delete from User where id=:userId");
    	
    	theQuery.setParameter("userId",theId);
    	
    	theQuery.executeUpdate();
    }
    
    @Override
    @Transactional
    public User getUserById(int theId) {
    	// Bây gọi session trong hibernate
    	Session currentSession = sessionFactory.getCurrentSession();
    	
    	// Bây giờ lấy từ database sử dung khóa chính
    	User theUser = currentSession.get(User.class, theId);
    	
    	return theUser;
    }
    
	/*
	 * @Override
	 * 
	 * @Transactional public void updateUser(User theUser) { // bây giờ gọi session
	 * hibernate Session currentSession = sessionFactory.getCurrentSession();
	 * 
	 * currentSession.update(theUser);// cập nhật lại user vào DB }
	 */
    @Override
    @Transactional
    public void updateUser(User theUser) {
    Session currentSession = sessionFactory.getCurrentSession();

    try {
//    	System.out.println("Saving..." + theUser.getFullName() + "------" +theUser.getId());
    currentSession.update(theUser);
    } catch (StaleObjectStateException e) {
	    // Handle the exception (e.g., log it) and consider retrying the update.
	    // You might want to reload theUser from the database and apply the changes again.
    	System.out.println("Hello World");
      }
    }    
    
    
    @Override
    @Transactional
    public List<User> getUserBySearch(String searchValue) {
    	// Bây giờ gọi session hibernate
    	Session currentSession = sessionFactory.getCurrentSession();
    	
		/*
		 * Tạo ra câu lệnh query
		 */	
    	
		Query<User> theQuery = currentSession.createQuery("from User where phoneNumber like :searchValue or email like :searchValue", User.class);

		theQuery.setParameter("searchValue", "%" + searchValue + "%");
		
		/* Thực hiện câu lệnh truy vấn và trả về List */
		List<User> users = theQuery.getResultList();
		
		// Trả về user
		return users;
    	
    }
    
    @Override
    @Transactional
    public void getLockUp(int idUser) {
    	Session currentSession = sessionFactory.getCurrentSession();
    	
    	Query<User> theQuery = currentSession.createQuery("update User set status = 1 where id = :idUser ");
    	
    	theQuery.setParameter("idUser", idUser);
    	
    	theQuery.executeUpdate();
    }
    
    @Override
    @Transactional
    public void getOpen(int idUser) {
    	Session currentSession = sessionFactory.getCurrentSession();
    	
    	Query<User> theQuery = currentSession.createQuery("update User set status = 0 where id = :idUser ");
    	
    	theQuery.setParameter("idUser", idUser);
    	
    	theQuery.executeUpdate();
    }
 
}
