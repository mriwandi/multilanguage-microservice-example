package com.example.user.service;

import com.example.user.entity.User;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface UserService {
	Page<User> getUsers(int pageNum, int pageSize, String sortField, String sortMethod);
	Optional<User> getUserById(Long id);
	User createUser(String name);
}
