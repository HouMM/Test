package dao;

import java.util.List;

import pojo.User;

public interface UserDao {
	public User addUser(User u);
	public List<User> findAllUser();
}
