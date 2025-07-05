package com.example.user.dto;

import com.example.user.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
	private Long id;
	private String name;
	private Long createdAt;
	private Long updatedAt;

	public static UserDTO fromEntity(User user) {
		return UserDTO.builder()
				.id(user.getId())
				.name(user.getName())
				.createdAt(user.getCreatedAt())
				.updatedAt(user.getUpdatedAt())
				.build();
	}
}
