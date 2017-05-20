package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dao.UserDao;
import pojo.User;
@Repository
public class UserDaoImpl implements UserDao{
	
	@PersistenceContext(name="mysql")
	private EntityManager manager;
	
	@Override
	public User addUser(User u) {
		manager.persist(u);
		return u;
	}

	@Override
	public List<User> findAllUser() {
		String jpql="from User u where u.age = :age";
		List<User> users=manager.createQuery(jpql)
				.setParameter("age", 50)
				.getResultList();
		return users;
	}
	
}
