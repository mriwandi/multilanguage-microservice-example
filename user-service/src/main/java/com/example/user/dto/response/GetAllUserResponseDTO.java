package com.example.user.dto.response;

import com.example.user.dto.UserDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetAllUserResponseDTO {
	private boolean result;
	private List<UserDTO> users;
}
