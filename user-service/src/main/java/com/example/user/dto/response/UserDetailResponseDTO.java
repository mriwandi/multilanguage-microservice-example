package com.example.user.dto.response;

import com.example.user.dto.UserDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDetailResponseDTO {
	private Boolean result;
	private UserDTO user;
}
