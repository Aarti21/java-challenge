package jp.co.axa.apidemo.services;

import java.util.List;

import jp.co.axa.apidemo.entities.User;

public interface UserService {

	public List<User> retrieveUsers();

	public User getUser(Long userId);

	public void saveUser(User user);

	public void deleteUser(Long userId);

	public void updateUser(User user);

}
