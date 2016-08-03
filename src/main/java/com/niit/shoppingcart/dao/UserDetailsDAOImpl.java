
package com.niit.shoppingcart.dao;

import java.util.List;




import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.UserDetails;

@Repository("userdetailsDAO")
public class UserDetailsDAOImpl implements UserDetailsDAO {
	

	@Autowired
	private SessionFactory sessionFactory;


	public UserDetailsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Transactional
	public void saveOrUpdate(UserDetails userdetails) {
		sessionFactory.getCurrentSession().saveOrUpdate(userdetails);
	
			
	}

	@Transactional
	public void delete(String id) {
		UserDetails userdetails = new UserDetails();
		userdetails.setId(id);
		sessionFactory.getCurrentSession().delete(userdetails);
	}

	@Transactional
	public UserDetails get(String id) {
		String hql = "from UserDetails where id=" + "'"+ id +"'";
		//  from userdetails where id = '101'
		Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		List<UserDetails> listUserDetails = (List<UserDetails>) query.list();
		
		if (listUserDetails != null && !listUserDetails.isEmpty()) {
			return listUserDetails.get(0);
		}
		return null;
	}
	
	@Transactional
	public List<UserDetails> list() {
		@SuppressWarnings("unchecked")
		List<UserDetails> listUserDetails = (List<UserDetails>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(UserDetails.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUserDetails;
	}
	
	


}
