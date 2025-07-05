package com.example.user.controller;

import com.example.user.dto.request.UserCreateRequest;
import com.example.user.dto.response.ApiUserResponse;
import com.example.user.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public-api/users")
@AllArgsConstructor
public class PublicUserController {

	private final UserService userService;

	@PostMapping
	public ResponseEntity<ApiUserResponse> createUser(@RequestBody @Valid UserCreateRequest request) {
		return ResponseEntity.ok(userService.createUser(request));
	}
}
