package com.example.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateUserRequestDTO {

	@NotBlank(message = "Name is required")
	private String name;
}
