package com.example.user.dto.response;

import com.example.user.dto.UserDTO;
import lombok.Data;

@Data
public class ApiUserResponse {
	private boolean result;
	private UserDTO user;
}
