package com.example.user.service.impl;

import com.example.user.client.UserClient;
import com.example.user.dto.request.UserCreateRequest;
import com.example.user.dto.response.ApiUserResponse;
import com.example.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserClient userClient;

	@Override
	public ApiUserResponse createUser(UserCreateRequest request) {

		return userClient.createUser(request);
	}
}
