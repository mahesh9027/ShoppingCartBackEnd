package com.niit.shoppingcart.dao;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.User;
import com.niit.shoppingcart.model.UserDetails;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	

	@Autowired
	private SessionFactory sessionFactory;


	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Transactional
	public void saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
			
	}

	@Transactional
	public void delete(String id) {
		User user = new User();
		user.setId(id);
		sessionFactory.getCurrentSession().delete(user);
	}

	@Transactional
	public User get(String id) {
		String hql = "from User where id=" + "'"+ id +"'";
		//  from user where id = '101'
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		List<User> listUser = (List<User>) query.list();
		
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		return null;
	}
	
	@Transactional
	public List<User> list() {
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
	}



	public void saveOrUpdate(UserDetails userDetails) {
		// TODO Auto-generated method stub
		
	}



	public boolean isValidUser(String userID, String password) {
		// TODO Auto-generated method stub
		return false;
	}



	public void saveOrpdate(User user) {
		// TODO Auto-generated method stub
		
	}
	
	


}
