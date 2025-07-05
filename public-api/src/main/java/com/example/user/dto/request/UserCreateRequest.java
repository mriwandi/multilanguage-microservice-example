package com.example.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserCreateRequest {

	@NotBlank(message = "Name is required")
	private String name;
}
