package com.example.user.dto;

import lombok.Data;

@Data
public class UserDTO {
	private Long id;
	private String name;
	private Long createdAt;
	private Long updatedAt;
}
