package com.example.user.service.impl;

import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import com.example.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public Page<User> getUsers(int pageNum, int pageSize, String sortField, String sortMethod) {
		Sort sortOrder = Sort.by(Sort.Order.by(sortField).with(Sort.Direction.fromString(sortMethod)));
		Pageable paging = PageRequest.of(pageNum, pageSize, sortOrder);
		return userRepository.findAll(paging);
	}

	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	public User createUser(String name) {
		User user = User.builder()
			.name(name)
			.build();
		return userRepository.save(user);
	}
}
