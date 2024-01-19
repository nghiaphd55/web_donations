package com.web.donations.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.donations.entity.Role;


@Repository
public class RoleDaoImplement implements RoleDao {

	// Nhúng session factory	
	@Autowired
	private SessionFactory sessionFactory;
	
	/* Hàm này dùng hiển thị Role */
	@Override
	@Transactional
	public List<Role> getRole() {
		/* Lấy phiên làm  việc session  */
		Session currentSession = sessionFactory.getCurrentSession();
		
		/* Tạo câu truy vấn*/
		Query<Role> query = currentSession.createQuery("from Role", Role.class);
		
		/* Thực hiện cậu lệnh truy vấn */ 
		List<Role> roles = query.getResultList();
		
		/* Trả về kết quả */
		return roles;
	}
}
