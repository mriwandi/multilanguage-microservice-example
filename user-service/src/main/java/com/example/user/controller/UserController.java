package com.example.user.controller;

import com.example.user.dto.request.CreateUserRequestDTO;
import com.example.user.dto.response.GetAllUserResponseDTO;
import com.example.user.dto.UserDTO;
import com.example.user.dto.response.UserDetailResponseDTO;
import com.example.user.entity.User;
import com.example.user.exception.UserNotFoundException;
import com.example.user.service.UserService;
import com.example.user.utils.StringUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public GetAllUserResponseDTO getAllUsers(
		@RequestParam(name = "page_num", defaultValue = "1") int pageNum,
		@RequestParam(name = "page_size", defaultValue = "10") int pageSize,
		@RequestParam(defaultValue = "created_at, desc") String[] sort
	) {
		String sortField = StringUtils.snakeToCamel(sort[0]);
		String sortMethod = sort[1];

		Page<User> userPage = userService.getUsers(pageNum - 1, pageSize, sortField, sortMethod);
		List<UserDTO> users = userPage.getContent().stream()
			.map(UserDTO::fromEntity)
			.toList();

		return GetAllUserResponseDTO.builder()
			.result(true)
			.users(users)
			.build();
	}

	@GetMapping("/{id}")
	public UserDetailResponseDTO getSpecificUser(@PathVariable Long id) {
		User user = userService.getUserById(id)
			.orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

		return UserDetailResponseDTO.builder()
			.result(true)
			.user(UserDTO.fromEntity(user)).build();
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserDetailResponseDTO createUser(@Valid @RequestBody CreateUserRequestDTO body) {
		User user = userService.createUser(body.getName());

		return UserDetailResponseDTO.builder()
			.result(true)
			.user(UserDTO.fromEntity(user)).build();
	}
}
