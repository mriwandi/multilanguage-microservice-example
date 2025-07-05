package com.example.user.service;

import com.example.user.dto.request.UserCreateRequest;
import com.example.user.dto.response.ApiUserResponse;

public interface UserService {
	ApiUserResponse createUser(UserCreateRequest request);
}
