package jp.co.axa.apidemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.axa.apidemo.entities.User;
import jp.co.axa.apidemo.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> retrieveUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}

	public User getUser(Long userId) {
		Optional<User> optEmp = userRepository.findById(userId);
		return optEmp.get();
	}

	public void saveUser(User user) {
		userRepository.save(user);
	}

	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

	public void updateUser(User user) {
		userRepository.save(user);
	}
}
